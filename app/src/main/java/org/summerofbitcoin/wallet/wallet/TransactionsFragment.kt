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
import org.bitcoindevkit.bdkjni.Types.TransactionDetails
import org.summerofbitcoin.wallet.R
import org.summerofbitcoin.wallet.data.Wallet
import org.summerofbitcoin.wallet.databinding.FragmentTransactionsBinding

class TransactionsFragment : Fragment() {

    private lateinit var binding: FragmentTransactionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.transactionsView.text = transactionList()

        val navController = Navigation.findNavController(view)
        binding.transactionsToWalletButton.setOnClickListener {
            navController.navigate(R.id.action_transactionsFragment_to_walletFragment)
        }
    }

    private fun transactionList(): String {
        val rawList: List<TransactionDetails> = Wallet.listTransactions()
        var finalList: String = ""
        for (item in rawList) {
            Log.i("SobiWallet", "Transaction list item: $item")
            val transactionInfo: String =
                "Timestamp: ${item.timestamp}\nReceived: ${item.received}\nSent: ${item.sent}\nFees: ${item.fees}\nTxid: ${item.txid}"

            finalList = "$finalList\n$transactionInfo\n"
        }
        return finalList
    }
}
