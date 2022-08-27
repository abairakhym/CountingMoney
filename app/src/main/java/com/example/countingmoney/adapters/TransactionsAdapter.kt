package com.example.countingmoney.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.countingmoney.R
import com.example.countingmoney.databinding.TransactionItemBinding
import com.example.countingmoney.model.Transaction

class TransactionsAdapter  : RecyclerView.Adapter<TransactionsAdapter.OperationViewHolder>() {

    private var onItemClickListener: ((Transaction) -> Unit)? = null  //click listener

    private val differCallback = object : DiffUtil.ItemCallback<Transaction>() {
        override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem.title == newItem.title
        }
        override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.transaction_item, parent, false)
        return OperationViewHolder(view)
    }

    override fun onBindViewHolder(holder: OperationViewHolder, position: Int) {
        holder.apply {
            bind(differ.currentList.get(position))
            itemView.setOnClickListener {
                onItemClickListener?.let { it(differ.currentList.get(position)) }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

   fun setOnItemClickListener(listener: (Transaction) -> Unit) {
       onItemClickListener = listener
   }

    inner class OperationViewHolder (item: View) : RecyclerView.ViewHolder(item) {
        val binding = TransactionItemBinding.bind(item)
        fun bind(transaction: Transaction) {
            binding.apply {
                tvTitle.text = transaction.title
                tvMoney.text = transaction.amount.toString()
                tvCategory.text = transaction.category
                transaction.image?.let { ivTransaction.setImageResource(it) }
            }
        }
    }
}