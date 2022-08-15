package com.example.countingmoney.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.countingmoney.repo.TransactionRepository

class TransactionsViewModelProviderFactory constructor(private val transactionRepository: TransactionRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TransactionViewModel::class.java)){
            TransactionViewModel(this.transactionRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel not found(Не нашлось)")
        }
    }
}