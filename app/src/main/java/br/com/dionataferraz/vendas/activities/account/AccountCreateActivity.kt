package br.com.dionataferraz.vendas.activities.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import br.com.dionataferraz.vendas.databinding.ActivityAccountCreateBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class AccountCreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountCreateBinding
    private lateinit var viewModel: AccountCreateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountCreateBinding.inflate(layoutInflater)
        viewModel = AccountCreateViewModel()

        val view = binding.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences(
            "Account",
            MODE_PRIVATE
        )

        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(AccountModel::class.java)

        binding.saveButton.setOnClickListener{

            val radioGroup: RadioGroup
            radioGroup = binding.radioGroup
            val radioButtonSelected: Int = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(radioButtonSelected)

            val name = binding.tvName.text.toString()
            val balance = binding.tvBalance.text
            val responsible = binding.tvResponsible.text.toString()
            val type = radioButton.text.toString()

        }
    }
}