package com.example.countingmoney.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countingmoney.model.Transaction
import com.example.countingmoney.repo.TransactionRepository
import kotlinx.coroutines.launch

class MainFragmentViewModel(private val transactionRepository: TransactionRepository): ViewModel() {
    //insert transaction
    fun insertTransaction(transaction: Transaction) = viewModelScope.launch {
        transactionRepository.insert(transaction)
    }
    //update transaction
    fun updateTransaction(transaction: Transaction) = viewModelScope.launch {
        transactionRepository.update(transaction)
    }
    //delete transaction
    fun deleteTransaction(transaction: Transaction) = viewModelScope.launch {
        transactionRepository.delete(transaction)
    }

    //get single transaction type - expense or income
    fun getAllSingleTransaction(transactionType: String) = viewModelScope.launch {
        transactionRepository.getAllSingleTransaction(transactionType)
    }
}