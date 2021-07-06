/*
 * Copyright 2021 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE file.
 */

package org.summerofbitcoin.wallet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.summerofbitcoin.wallet.databinding.ActivityWalletChoiceBinding

class WalletChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityWalletChoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        binding.newWalletButton.setOnClickListener {
            val intent: Intent = Intent(this, WalletActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
