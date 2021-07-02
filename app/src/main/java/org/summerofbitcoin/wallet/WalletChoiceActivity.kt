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

        binding.thankYouButton.setOnClickListener {
            val intent: Intent = Intent(this, WalletActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
