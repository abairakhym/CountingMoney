package com.example.countingmoney.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.countingmoney.MainActivity
import com.example.countingmoney.R
import com.example.countingmoney.databinding.FragmentEditTransactionBinding
import com.example.countingmoney.model.Transaction
import com.example.countingmoney.utils.Constants
import com.example.countingmoney.utils.binding.BindingFragment

class EditTransactionFragment : BindingFragment<FragmentEditTransactionBinding>(
    FragmentEditTransactionBinding::inflate) {
    lateinit var viewModel: TransactionViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val getTransaction: Transaction = arguments?.get(Constants.KEY_WORD) as Transaction

        binding.apply {
            etTitle.setText(getTransaction.title)
            etAmount.setText(getTransaction.amount.toString())
            val transactionType = when(getTransaction.transaction_type) {
                "Expenses" -> 0
                "Income" -> 1
                else -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
            spnTransactionType.setSelection(transactionType as Int)
            val tag = when(getTransaction.category) {
                "Entertaiment" -> 0
                "Transportation" -> 1
                "Cafe" -> 2
                "Groceries" -> 3
                "Workout" -> 4
                "Investments" -> 5
                "Other" -> 6
                else -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()}
            }
            spnTag.setSelection(tag as Int)
            btnEditDate.setText(getTransaction.time)
            etDescription.setText(getTransaction.description)

            toolbar.apply {
                tvTbTitle.text = "Edit Transaction"
                ibTbBack.setOnClickListener {
                    findNavController().navigate(R.id.action_editTransactionFragment_to_mainFragment)
                }
            }
            btnEditTransaction.setOnClickListener {
                val transaction = Transaction(id = getTransaction.id,
                    amount = etAmount.text.toString().toDouble(),
                    title = etTitle.text.toString(),
                    description = etDescription.text.toString(),
                    transaction_type = spnTransactionType.selectedItem.toString(),
                    category = spnTag.selectedItem.toString(),
                    time = "husdak")
                when (transaction.category) {
                    "Entertaiment" -> {transaction.image = R.drawable.entertaiment}
                    "Transportation" -> {transaction.image = R.drawable.transportation}
                    "Cafe" -> {transaction.image = R.drawable.cafe}
                    "Groceries" -> {transaction.image = R.drawable.groceries}
                    "Workout" -> {transaction.image = R.drawable.workout}
                    "Investments" -> {transaction.image = R.drawable.investing}
                    "Other" -> {transaction.image = R.drawable.other}
                }
                viewModel.updateTransaction(transaction)
                findNavController().navigate(R.id.action_editTransactionFragment_to_mainFragment)
            }
        }
    }
}