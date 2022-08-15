package com.example.countingmoney.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countingmoney.model.Transaction
import com.example.countingmoney.repo.TransactionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransactionViewModel(private val transactionRepository: TransactionRepository): ViewModel() {
    //insert transaction
    fun insertTransaction(transaction: Transaction) = viewModelScope.launch(Dispatchers.IO) {
        transactionRepository.insert(transaction)
    }
    //update transaction
    fun updateTransaction(transaction: Transaction) = viewModelScope.launch(Dispatchers.IO) {
        transactionRepository.update(transaction)
    }
    //delete transaction
    fun deleteTransaction(transaction: Transaction) = viewModelScope.launch(Dispatchers.IO) {
        transactionRepository.delete(transaction)
    }

    fun getAllTransaction() = transactionRepository.getAllTransaction()

    //get single transaction type - expense or income
    fun getAllSingleTransaction(transactionType: String) = transactionRepository.getAllSingleTransaction(transactionType)

}