package com.example.countingmoney.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.countingmoney.MainActivity
import com.example.countingmoney.R
import com.example.countingmoney.databinding.FragmentAddTransactionBinding
import com.example.countingmoney.model.Transaction
import com.example.countingmoney.utils.binding.BindingFragment

class AddTransactionFragment : BindingFragment<FragmentAddTransactionBinding>(
    FragmentAddTransactionBinding::inflate) {

    lateinit var viewModel: TransactionViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        setupListeners()
    }

    private fun setupListeners() {
        binding.apply {
            btnAddTransaction.setOnClickListener {
                //add dato to db
                if(etAmount.text != null && etTitle.text != null && etDescription.text != null && spnTag.selectedItem != null && spnTransactionType.selectedItem != null) {
                    val transaction = Transaction(amount = etAmount.text.toString().toDouble(),
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
                    viewModel.insertTransaction(transaction)
                    findNavController().navigateUp()
                }
            }
            toolbar.apply {
                tvTbTitle.text = "Add Transaction"
                ibTbBack.setOnClickListener {
                    findNavController().navigateUp()
                }
            }
        }
    }
}