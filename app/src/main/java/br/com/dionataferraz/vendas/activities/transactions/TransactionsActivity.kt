package br.com.dionataferraz.vendas.activities.transactions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.dionataferraz.vendas.adapters.TransactionAdapter
import br.com.dionataferraz.vendas.databinding.ActivityTransactionsBinding
import java.util.*

class TransactionsActivity : AppCompatActivity(), TransactionAdapter.Listener {

    private lateinit var binding: ActivityTransactionsBinding
    private lateinit var viewModel : TransactionsViewModel

    private val adapter: TransactionAdapter by lazy {
        TransactionAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransactionsBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Transações")

        val transaction = TransactionModel(
            date = Date(2022,9,21,18,13),
            value = 10.00,
            description = "Mercado",
            place = Place.MARKET
        )

        binding.rcList.adapter = adapter
        adapter.addItem(transaction)


    }

    override fun onItemClick(text: TransactionModel) {
        Toast.makeText(
            this,
            text.toString(),
            Toast.LENGTH_LONG
        ).show()
    }
}