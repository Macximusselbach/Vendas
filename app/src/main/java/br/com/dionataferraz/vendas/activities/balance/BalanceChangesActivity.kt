package br.com.dionataferraz.vendas.activities.balance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dionataferraz.vendas.databinding.ActivityBalanceChangesBinding

class BalanceChangesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBalanceChangesBinding
    private lateinit var viewModel: BalanceChangesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBalanceChangesBinding.inflate(layoutInflater)
        viewModel = BalanceChangesViewModel()

        val view = binding.root
        setContentView(view)

    }
}