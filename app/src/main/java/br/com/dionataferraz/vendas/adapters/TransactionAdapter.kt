package br.com.dionataferraz.vendas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.activities.transactions.TransactionModel
import br.com.dionataferraz.vendas.activities.transactions.TransactionPlace
import br.com.dionataferraz.vendas.databinding.ItemListBinding

class TransactionAdapter(private val listener: Listener) :
    RecyclerView.Adapter<TransactionViewHolder>() {

    interface Listener {
        fun onItemClick(transaction: TransactionModel)
    }

    private val listItem: MutableList<TransactionModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

//    fun addItem(transaction: TransactionModel) {
//        listItem.add(transaction)
//    }

    fun addList(list: MutableList<TransactionModel>) {
        listItem.addAll(list)

    }

}

class TransactionViewHolder(
    private val binding: ItemListBinding,
    private val listener: TransactionAdapter.Listener
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(transaction: TransactionModel) {

            fun Double.formats(qtd: Int) = "%.${qtd}f".format(this)

            binding.tvDescription.text = transaction.description
            binding.tvTime.text = transaction.date.hours.toString() + ":" + transaction.date.minutes.toString()
            binding.tvValue.text = "R$${transaction.value.formats(2)}"

            when (transaction.place) {
                TransactionPlace.MARKET -> binding.ivIcon.setImageResource(R.drawable.mercado)
                TransactionPlace.GAS -> binding.ivIcon.setImageResource(R.drawable.gasolina)
                TransactionPlace.SOCIAL -> binding.ivIcon.setImageResource(R.drawable.social)
            }



    }
}