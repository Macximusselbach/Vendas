package br.com.dionataferraz.vendas.activities.transactions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.activities.home.HomeActivity
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

        binding.btSave.setOnClickListener {
            val value = binding.etValue.text.toString()
            val place = binding.dropdownList.text.toString()
            val description = binding.etDescription.text.toString()

            viewModel.createTransaction(value, place, description)

        }



        viewModel.shouldShowHome.observe(this) { success ->
            if (success) {
                Toast.makeText(
                    this,
                    "Transação salva!",
                    Toast.LENGTH_LONG
                ).show()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            }
        }

        viewModel.shouldShowError.observe(this) { shouldShow ->
            if (!shouldShow.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    shouldShow,
                    Toast.LENGTH_LONG
                ).show()

            }
        }

    }
}