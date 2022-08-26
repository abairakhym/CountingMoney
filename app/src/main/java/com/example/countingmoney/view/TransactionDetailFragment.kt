package com.example.countingmoney.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.countingmoney.R
import com.example.countingmoney.databinding.FragmentTransactionDetailBinding
import com.example.countingmoney.model.Transaction
import com.example.countingmoney.utils.Constants
import com.example.countingmoney.utils.binding.BindingFragment

class TransactionDetailFragment : BindingFragment<FragmentTransactionDetailBinding>(
    FragmentTransactionDetailBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val transaction: Transaction = arguments?.get(Constants.KEY_WORD) as Transaction
        binding.apply {
            tvTitleDetail.text = transaction.title
            tvAmountDetail.text = transaction.amount.toString()
            tvTransactionTypeDetail.text = transaction.transaction_type
            tvTagDetail.text = transaction.category
            tvTimeDetail.text = transaction.time
            tvNoteDetail.text = transaction.description
            val bundle = Bundle().apply {
                putSerializable(Constants.KEY_WORD, transaction)
            }
            btnEditDetail.setOnClickListener {
                findNavController().navigate(R.id.action_transactionDetailFragment_to_editTransactionFragment, bundle)
            }
        }
    }
}