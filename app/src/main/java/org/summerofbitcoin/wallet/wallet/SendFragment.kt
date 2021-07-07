/*
 * Copyright 2021 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE file.
 */

package org.summerofbitcoin.wallet.wallet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.bitcoindevkit.bdkjni.Types.*
import org.summerofbitcoin.wallet.R
import org.summerofbitcoin.wallet.data.Wallet
import org.summerofbitcoin.wallet.databinding.FragmentSendBinding
import org.summerofbitcoin.wallet.utilities.SnackbarLevel
import org.summerofbitcoin.wallet.utilities.showSnackbar

class SendFragment : Fragment() {

    private lateinit var binding: FragmentSendBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        binding.sendToWalletButton.setOnClickListener {
            navController.navigate(R.id.action_sendFragment_to_walletFragment)
        }


        binding.toBroadcastConfirmation.setOnClickListener {
            val broadcastTransactionDialog =
                MaterialAlertDialogBuilder(this@SendFragment.requireContext(), R.style.NordDialogTheme)
                    .setTitle("Confirm transaction")
                    .setMessage(buildConfirmTransactionMessage())
                    .setPositiveButton("Broadcast") { _, _ ->
                        Log.i("SobiWallet", "User is attempting to broadcast transaction")
                        broadcastTransaction()
                        navController.navigate(R.id.action_sendFragment_to_walletFragment)
                    }
                    .setNegativeButton("Go back") { _, _ ->
                        Log.i("SobiWallet", "User is not broadcasting")
                    }
            broadcastTransactionDialog.show()
        }
    }

    private fun buildConfirmTransactionMessage(): String {
        val sendToAddress: String = binding.sendToAddress.text.toString().trim()
        val sendAmount: String = binding.sendAmount.text.toString().trim()
        Log.i("SobiWallet", "Message has inputs $sendToAddress, $sendAmount")
        val message: String = "Send to:\n$sendToAddress\n\nAmount:\n$sendAmount satoshis\n"
        return message
    }

    private fun broadcastTransaction() {
        try {
            // build required transaction information from text inputs
            val feeRate = 1F
            val sendToAddress: String = binding.sendToAddress.text.toString().trim()
            val sendAmount: String = binding.sendAmount.text.toString().trim()
            val addressAndAmount: List<Pair<String, String>> = listOf(Pair(sendToAddress, sendAmount))

            val transactionDetails: CreateTxResponse = Wallet.createTransaction(feeRate, addressAndAmount, false, null, null, null)
            val signResponse: SignResponse = Wallet.sign(transactionDetails.psbt)

            val rawTx: RawTransaction = Wallet.extractPsbt(signResponse.psbt)
            val txid: Txid = Wallet.broadcast(rawTx.transaction)

            Log.i("SobiWallet", "Transaction was broadcast! txid: $txid")
            showSnackbar(
                requireView(),
                SnackbarLevel.SUCCESS,
                "Transaction was broadcast successfully!"
            )
        } catch (e: Throwable) {
            Log.i("SobiWallet", "Broadcast error: ${e.message}")
            showSnackbar(
                requireView(),
                SnackbarLevel.ERROR,
                "Broadcast error: ${e.message}"
            )
        }
    }
}
