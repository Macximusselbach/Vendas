package br.com.dionataferraz.vendas.activities.splashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.activities.home.HomeActivity
import br.com.dionataferraz.vendas.activities.login.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = SplashViewModel()


        CoroutineScope(Dispatchers.IO).launch {
            viewModel.checkExistsProfile()

        }


        viewModel.shouldGoHome.observe(this) { shouldGoHome ->
            if (shouldGoHome) {
                Handler().postDelayed({
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()

                }, 5000)


            } else {
                Handler().postDelayed({
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()

                }, 5000)


            }
        }

    }
}