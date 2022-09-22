package br.com.dionataferraz.vendas.activities.transactions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dionataferraz.vendas.adapters.TransactionAdapter
import br.com.dionataferraz.vendas.databinding.ActivityTransactionsBinding

class TransactionsActivity : AppCompatActivity(), TransactionAdapter.Listener {

    private lateinit var binding: ActivityTransactionsBinding
    private lateinit var viewModel : TransactionsViewModel

    private val adapter: TransactionAdapter by lazy {
        TransactionAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        viewModel = TransactionsViewModel()

        val view = binding.root
        setContentView(view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Transações")

        val sharedPreferences = getSharedPreferences(
            "Transactions",
            MODE_PRIVATE
        )

        viewModel.saveTransactionOnSP(sharedPreferences)
        viewModel.getTransactionsOnSP(sharedPreferences)

        viewModel.showTransactions.observe(this) { listToShow ->

            binding.rcList.adapter = adapter
            adapter.addList(listToShow)
        }

    }

    override fun onItemClick(text: TransactionModel) {

    }
}