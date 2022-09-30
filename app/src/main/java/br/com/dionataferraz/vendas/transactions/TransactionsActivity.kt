package br.com.dionataferraz.vendas.transactions

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.databinding.ActivityTransactionsBinding

class TransactionsActivity : AppCompatActivity(), TransactionAdapter.Listener {

    private lateinit var binding: ActivityTransactionsBinding
    private lateinit var viewModel: TransactionsViewModel

    private val adapter: TransactionAdapter by lazy {
        TransactionAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = TransactionsViewModel()

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
}
