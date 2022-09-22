package br.com.dionataferraz.vendas.activities.balance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dionataferraz.vendas.databinding.ActivityChangeBalanceBinding

class ChangeBalanceActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChangeBalanceBinding
    private lateinit var viewModel: ChangeBalanceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChangeBalanceBinding.inflate(layoutInflater)
        viewModel = ChangeBalanceViewModel()

        val view = binding.root
        setContentView(view)


    }
}