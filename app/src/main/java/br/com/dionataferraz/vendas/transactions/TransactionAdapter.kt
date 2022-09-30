package br.com.dionataferraz.vendas.transactions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.databinding.ItemListBinding

class TransactionAdapter(private val listener: Listener) :
    RecyclerView.Adapter<TransactionViewHolder>() {

    interface Listener {
        //fun onItemClick(transaction: TransactionModel)
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

    fun addNewList(list: List<TransactionModel>) {
        listItem.clear()
        notifyItemRangeRemoved(0, listItem.size)
        listItem.addAll(list)
    }

    fun addList(list: List<TransactionModel>) {
        listItem.addAll(list)
    }

    fun updateItem(item: TransactionModel, position: Int) {
        listItem[position] = item
        notifyItemChanged(position)
    }

}

class TransactionViewHolder(
    private val binding: ItemListBinding,
    private val listener: TransactionAdapter.Listener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(transaction: TransactionModel) {

        fun Double.formats(qtd: Int) = "%.${qtd}f".format(this)

        binding.tvOperation.text = transaction.operation
        binding.tvDate.text = transaction.date
        binding.tvValue.text = "R$${transaction.value.formats(2)}"

        when (transaction.operation) {
            "Deposit" -> binding.ivIcon.setImageResource(R.drawable.ic_baseline_attach_money_24)
            "Withdraw" -> binding.ivIcon.setImageResource(R.drawable.ic_baseline_money_off_24)
        }


    }
}