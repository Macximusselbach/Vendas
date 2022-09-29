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

        binding.button.setOnClickListener {
            adapter.updateItem(
                "MUDOU AQUI", 6
            )
/*            adapter.addNewList(
                listOf(
                    "Item 11",
                    "Item 10",
                    "Item 9"
                )
            )*/
        }

        binding.rcList.adapter = adapter
        adapter.addList(
            listOf(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10",
                "Item 11",
            )
        )
    }

    override fun onItemClick(text: String) {
        Toast.makeText(
            this,
            text,
            Toast.LENGTH_LONG
        ).show()
    }
}