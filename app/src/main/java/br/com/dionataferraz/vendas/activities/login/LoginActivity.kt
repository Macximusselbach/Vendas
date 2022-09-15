package br.com.dionataferraz.vendas.activities.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.activities.home.HomeActivity
import br.com.dionataferraz.vendas.activities.profile.ProfileCreateActivity
import br.com.dionataferraz.vendas.databinding.ActivityLoginBinding
import java.math.BigDecimal
import java.math.BigInteger

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        viewModel = LoginViewModel()

        val view = binding.root
        setContentView(view)

        binding.btCreateProfile.setOnClickListener {
            val intent = Intent(this, ProfileCreateActivity::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.login(email = email, password = password)

        }

        viewModel.shouldShowHome.observe(this) { goHome ->
            if (goHome) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            }
        }

        viewModel.shouldShowError.observe(this) { shouldShow ->
            if (shouldShow) {
                Toast.makeText(
                    this,
                    "Deu ruim",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Login realizado",
                    Toast.LENGTH_LONG
                )
            }
        }
    }
}