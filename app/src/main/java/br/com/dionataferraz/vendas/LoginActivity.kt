package br.com.dionataferraz.vendas

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        viewModel = LoginViewModel()

        val view = binding.root
        setContentView(view)

        binding.btLogin.setOnClickListener {

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.login(email, password)

        }

        viewModel.shouldShowError.observe(this) { shouldShow ->
            if (shouldShow != null){
                Toast.makeText(
                    this,
                    shouldShow,
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Login realizado",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        viewModel.shouldShowHome.observe(this) { goHome ->
            if (goHome) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            }
        }

    }
}