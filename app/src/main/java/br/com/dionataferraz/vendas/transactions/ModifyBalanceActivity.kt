package br.com.dionataferraz.vendas.transactions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dionataferraz.vendas.databinding.ActivityModifyBalanceBinding

class ModifyBalanceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModifyBalanceBinding
    private lateinit var viewModel: TransactionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityModifyBalanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = TransactionsViewModel()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Transações")

    }
}