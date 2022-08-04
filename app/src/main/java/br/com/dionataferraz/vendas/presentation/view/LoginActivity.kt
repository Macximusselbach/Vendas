package br.com.dionataferraz.vendas.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.presentation.presenter.LoginContract
import br.com.dionataferraz.vendas.presentation.presenter.LoginPresenter

class LoginActivity  : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter

    lateinit var loginInput : EditText
    lateinit var passwordInput : EditText
    lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Bind do Presenter com a nossa View
        presenter = LoginPresenter(this)

        bindViews()

        btnLogin.setOnClickListener {
            //Comunica e Transfere a responsabilidade do Login para o Presenter
            //Que então irá validar se o Login é válido ou não.
            presenter.isLoginValid(loginInput.text.toString(), passwordInput.text.toString())
        }
    }

    override fun displayErrorMessage() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        loginInput.error = "Login Failed!"
        passwordInput.error = "Login Failed!"
    }

    override fun displaySucessToast() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
    }

    override fun startHomeActivity() {
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }

    fun bindViews() {
        loginInput = findViewById(R.id.username)
        passwordInput = findViewById(R.id.password)
        btnLogin = findViewById(R.id.login)
    }
}
