package br.com.dionataferraz.vendas.activities.transactions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        viewModel.getTransactions()

        viewModel.showTransactions.observe(this) { listToShow ->

            binding.rcList.adapter = adapter
            adapter.addList(listToShow)

        }

        viewModel.shouldShowError.observe(this) { shouldShow ->
            Toast.makeText(
                this,
                shouldShow,
                Toast.LENGTH_LONG
            ).show()

        }

    }

    override fun onItemClick(text: TransactionModel) {

    }
}