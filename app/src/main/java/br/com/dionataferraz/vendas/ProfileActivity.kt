package br.com.dionataferraz.vendas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val sharedPreferences = getSharedPreferences(
            "Profile",
            MODE_PRIVATE
        )

        val edit = sharedPreferences.edit()

        val person = Person(
            name = "Macximus",
            age = 21
        )

        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

        val adapter = moshi.adapter(Person::class.java)
        val personString = adapter.toJson(person)
        edit.putString("Person", personString)
        edit.apply()

        findViewById<TextView>(R.id.tv_password).apply {
            val personFromSharedPreferences = sharedPreferences.getString("Person", null)
            val personFromAdapter = adapter.fromJson(
                personFromSharedPreferences

            )

            if (personFromAdapter != null) {
                text = "${personFromAdapter.name} ${personFromAdapter.age}"

            }

        }


    }

    data class Person(
        val name: String,
        val age: Int
    )

}