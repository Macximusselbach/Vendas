package br.com.dionataferraz.vendas.activities.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dionataferraz.vendas.activities.account.AccountCreateActivity
import br.com.dionataferraz.vendas.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.btCreateAccount.setOnClickListener {
            val intent = Intent(this, AccountCreateActivity::class.java)
            startActivity(intent)
        }
    }
}