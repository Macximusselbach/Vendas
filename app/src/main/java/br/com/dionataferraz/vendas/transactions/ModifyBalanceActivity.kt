package br.com.dionataferraz.vendas.transactions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.dionataferraz.vendas.databinding.ActivityModifyBalanceBinding
import java.text.SimpleDateFormat
import java.util.*

class ModifyBalanceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModifyBalanceBinding
    private lateinit var viewModel: ModifyBalanceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityModifyBalanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ModifyBalanceViewModel()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Operações")

        binding.btDeposit.setOnClickListener {
            val value = binding.etValue.text.toString()
            val date = getDateTime()

            viewModel.deposit(value, date)

        }

        binding.btWithdraw.setOnClickListener {
            val value = binding.etValue.text.toString()
            val date = getDateTime()

            viewModel.withdraw(value, date)

        }

        viewModel.shouldShowError.observe(this) { shouldShow ->
            if (shouldShow != null) {
                Toast.makeText(
                    this,
                    shouldShow,
                    Toast.LENGTH_LONG
                ).show()

            }
        }

    }

    private fun getDateTime(): String {
        val dateFormat = SimpleDateFormat(

            "dd/MM/yyyy - HH:mm", Locale.ROOT
        )

        val date = Date()

        return dateFormat.format(date)

    }
}