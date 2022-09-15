package br.com.dionataferraz.vendas.activities.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.activities.home.HomeActivity
import br.com.dionataferraz.vendas.activities.login.data.local.UserEntity
import br.com.dionataferraz.vendas.activities.login.data.local.VendasDatabase
import br.com.dionataferraz.vendas.activities.profile.ProfileCreateActivity
import br.com.dionataferraz.vendas.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.math.BigInteger

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        viewModel = LoginViewModel()

        val view = binding.root
        setContentView(view)

        binding.registerButton.setOnClickListener {
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

//        CoroutineScope(Dispatchers.IO).launch {
//            database.DAO().insertUser(
//                UserEntity(
//                    name = "Macximus",
//                    email = "max@gmail.com",
//                    password = "12345",
//                )
//            )
//
//            val users = database.DAO().getUser()
//            Log.e("DAO", users.toString())
//        }

    }
}