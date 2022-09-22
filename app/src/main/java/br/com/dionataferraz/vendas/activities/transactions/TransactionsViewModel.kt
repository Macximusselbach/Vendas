package br.com.dionataferraz.vendas.activities.transactions

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type
import java.util.*


class TransactionsViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val transactions: MutableLiveData<List<TransactionModel>> = MutableLiveData()
    val showTransactions: LiveData<List<TransactionModel>> = transactions

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .build()

    var listMyData: Type = Types.newParameterizedType(
        List::class.java,
        TransactionModel::class.java
    )

    private val moshiAdapter: JsonAdapter<List<TransactionModel>> = moshi.adapter(listMyData)


    fun saveTransactionOnSP(sharedPreferences: SharedPreferences) {

        val transactionsCreatedList = listOf(
            TransactionModel(
                date = Date(2022, 9, 21, 18, 13),
                value = 10.00,
                description = "Mercado",
                place = TransactionPlace.MARKET
            ),

            TransactionModel(
                date = Date(2022, 9, 21, 18, 13),
                value = 50.00,
                description = "Mercado",
                place = TransactionPlace.GAS
            ),

            TransactionModel(
                date = Date(2022, 9, 21, 18, 13),
                value = 10.00,
                description = "Mercado",
                place = TransactionPlace.SOCIAL
            )
        )

        val edit = sharedPreferences.edit()

        val transactionsToSave = moshiAdapter.toJson(transactionsCreatedList)

        edit.putString("Transactions", transactionsToSave)

        edit.apply()

    }

    fun getTransactionsOnSP(sharedPreferences: SharedPreferences) {

        val transactionsGot = sharedPreferences.getString("Transactions", null)

        transactions.value = moshiAdapter.fromJson(transactionsGot)

    }

}