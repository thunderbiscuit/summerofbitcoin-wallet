package org.summerofbitcoin.wallet.utilities

import android.content.SharedPreferences

class SharedPrefManager(private val sharedPreferences: SharedPreferences) {

    var path: String
        get() = sharedPreferences.getString(PREFS_PATH, "") ?: ""
        set(value) {
            sharedPreferences.edit()?.putString(PREFS_PATH, value)?.apply()
        }

    var descriptor: String
        get() = sharedPreferences.getString(PREFS_DESCRIPTOR, "") ?: ""
        set(value) {
            sharedPreferences.edit()?.putString(PREFS_DESCRIPTOR, value)?.apply()
        }

    var changeDescriptor: String
        get() = sharedPreferences.getString(PREFS_CHANGE_DESCRIPTOR, "") ?: ""
        set(value) {
            sharedPreferences.edit()?.putString(PREFS_CHANGE_DESCRIPTOR, value)?.apply()
        }

    var mnemonic: String
        get() = sharedPreferences.getString(PREFS_MNEMONIC, "No seed phrase saved")
            ?: "Seed phrase not there"
        set(value) {
            sharedPreferences.edit()?.putString(PREFS_MNEMONIC, value)?.apply()
        }

    var walletInitialised: Boolean
        get() = sharedPreferences.getBoolean(PREFS_WALLET_INITIALISED, true)
        set(value) {
            sharedPreferences.edit()?.putBoolean(PREFS_WALLET_INITIALISED, value)?.apply()
        }


    companion object {
        const val PREFS_WALLET_INITIALISED = "initialised"
        const val PREFS_PATH = "path"
        const val PREFS_DESCRIPTOR = "descriptor"
        const val PREFS_CHANGE_DESCRIPTOR = "changeDescriptor"
        const val PREFS_MNEMONIC = "mnemonic"
    }
}