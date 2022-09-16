package br.com.dionataferraz.vendas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dionataferraz.vendas.databinding.ActivityHomeBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.btCreateAccount.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)

        }

        val sharedPreferences = getSharedPreferences(
            "Account",
            MODE_PRIVATE
        )

        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(AccountModel::class.java)

        binding.teste.apply {
            val accountFromSharedPreferences = sharedPreferences.getString("Account", null)

            if (accountFromSharedPreferences != null) {
                val accountFromAdapter = adapter.fromJson(
                    accountFromSharedPreferences
                )

                if (accountFromAdapter != null) {
                    text =
                        " ${accountFromAdapter.accountName}" +
                                " ${accountFromAdapter.accountType}" +
                                " ${accountFromAdapter.balance} " +
                                " ${accountFromAdapter.responsible} "
                }
            }


        }
    }
}