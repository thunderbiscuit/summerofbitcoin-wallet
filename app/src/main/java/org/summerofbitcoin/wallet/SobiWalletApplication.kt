/*
 * Copyright 2021 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE file.
 */

package org.summerofbitcoin.wallet

import android.app.Application
import android.content.Context
import org.summerofbitcoin.wallet.data.Repository
import org.summerofbitcoin.wallet.data.Wallet

class SobiWalletApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // initialize Wallet object with path variable
        Wallet.setPath(applicationContext.filesDir.toString())

        // initialize Repository object with shared preferences
        Repository.setSharedPreferences(applicationContext.getSharedPreferences("current_wallet", Context.MODE_PRIVATE))
    }
}