package br.com.dionataferraz.vendas.activities.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dionataferraz.vendas.activities.account.AccountCreateActivity
import br.com.dionataferraz.vendas.activities.transactions.TransactionsActivity
import br.com.dionataferraz.vendas.activities.transactions.TransactionsCreateActivity
import br.com.dionataferraz.vendas.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        viewModel = HomeViewModel()

        val view = binding.root
        setContentView(view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Home")

        viewModel.sumMoney()

        binding.btCreateAccount.setOnClickListener {
            val intent = Intent(this, AccountCreateActivity::class.java)
            startActivity(intent)

        }

        binding.btTransactions.setOnClickListener {
            val intent = Intent(this, TransactionsActivity::class.java)
            startActivity(intent)
        }

        binding.btNewTransaction.setOnClickListener {
            val intent = Intent(this, TransactionsCreateActivity::class.java)
            startActivity(intent)
        }

        viewModel.showMoney.observe(this) { money ->
            binding.tvMoney.text = money
        }

    }
}