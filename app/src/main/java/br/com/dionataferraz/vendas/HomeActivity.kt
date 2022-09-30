package br.com.dionataferraz.vendas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.databinding.ActivityHomeBinding
import br.com.dionataferraz.vendas.transactions.ModifyBalanceActivity
import br.com.dionataferraz.vendas.transactions.TransactionsActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = HomeViewModel()

        viewModel.getBalance()

        viewModel.showBalance.observe(this) { balance ->
            binding.tvAccountBalance.text = balance.toString()

        }


        binding.btTransactions.setOnClickListener {
            val intent = Intent(App.context, TransactionsActivity::class.java)
            startActivity(intent)

        }

        binding.btModifyBalance.setOnClickListener {
            val intent = Intent(App.context, ModifyBalanceActivity::class.java)
            startActivity(intent)
        }
    }
}