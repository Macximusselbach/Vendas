package br.com.dionataferraz.vendas.activities.transactions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.databinding.ActivityTransactionsCreateBinding

class TransactionsCreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionsCreateBinding
    private lateinit var viewModel: TransactionsCreateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransactionsCreateBinding.inflate(layoutInflater)
        viewModel = TransactionsCreateViewModel()

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Transações")

        val dropdownAcTv = binding.dropdownList
        val dropdownOptions = arrayOf("MARKET", "GAS STATION", "PUB")
        val arrayAdapter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            dropdownOptions
        )

        dropdownAcTv.setAdapter(arrayAdapter)
        dropdownAcTv.threshold = 1

    }
}