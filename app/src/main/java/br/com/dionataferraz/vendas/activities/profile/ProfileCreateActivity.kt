package br.com.dionataferraz.vendas.activities.profile

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.activities.home.HomeActivity
import br.com.dionataferraz.vendas.databinding.ActivityProfileCreateBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class ProfileCreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileCreateBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileCreateBinding.inflate(layoutInflater)
        viewModel = ProfileViewModel()

        val view = binding.root
        setContentView(view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Home")

        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(ProfileModel::class.java)

        binding.pfSaveButton.setOnClickListener {

            val radioGroup: RadioGroup
            radioGroup = binding.radioGroup
            val radioButtonSelected: Int = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(radioButtonSelected)

            val name = binding.tvName.text.toString()
            val age = binding.tvAge.text.toString()
            val email = binding.tvEmail.text.toString()
            val password = binding.tvPassword.text.toString()
            val gender = radioButton.text.toString()

            viewModel.createPerson(name, age, email, password, gender)

        }

        binding.pfClearButton.setOnClickListener {

            clearFields()
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
            }
        }

        viewModel.sucessSave.observe(this) { sucess ->
            if (sucess) {
                Toast.makeText(
                    this,
                    "Perfil criado com sucesso!",
                    Toast.LENGTH_LONG
                ).show()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun clearFields() {
        binding.tvName.text = null
        binding.tvAge.text = null
        binding.tvEmail.text = null
        binding.tvPassword.text = null
        binding.radioGroup.clearCheck()

    }

}