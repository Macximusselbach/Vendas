package br.com.dionataferraz.vendas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import br.com.dionataferraz.vendas.databinding.ActivityAccountBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class AccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding
    private lateinit var viewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        viewModel = AccountViewModel()

        val view = binding.root
        setContentView(view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Conta")

        val sharedPreferences = getSharedPreferences(
            "Account",
            MODE_PRIVATE
        )

        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(AccountModel::class.java)

        binding.saveButton.setOnClickListener {

            val radioGroup: RadioGroup
            radioGroup = binding.radioGroup
            val radioButtonSelected: Int = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(radioButtonSelected)

            val name = binding.tvName.text.toString()
            val balance = binding.tvBalance.text.toString()
            val responsible = binding.tvResponsible.text.toString()
            val type = radioButton.text.toString()

            viewModel.createAccount(name, balance, responsible, type)

            viewModel.accountModelLiveData.observe(this) { account ->

                val edit = sharedPreferences.edit()

                val accountSave = adapter.toJson(account)
                edit.putString("Account", accountSave)
                edit.apply()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()

            }

            viewModel.shouldShowError.observe(this) { shouldShow ->
                if (shouldShow != null) {
                    Toast.makeText(
                        this,
                        shouldShow,
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "Conta criada com sucesso!",
                        Toast.LENGTH_LONG
                    )
                }
            }

        }
    }
}
