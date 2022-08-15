package com.example.countingmoney.repo

import com.example.countingmoney.db.AppDatabase
import com.example.countingmoney.model.Transaction

class TransactionRepository(val db: AppDatabase) {
    //insert transaction
    suspend fun insert(transaction: Transaction) = db.transactionDao().insertTransaction(transaction)

    //update transaction
    suspend fun update(transaction: Transaction) = db.transactionDao().updateTransaction(transaction)

    //delete transaction
    suspend fun delete(transaction: Transaction) = db.transactionDao().deleteTransaction(transaction)

    //get all transaction
    fun getAllTransaction() = db.transactionDao().getAllTransaction()

    //get single transaction type - expense or income
    fun getAllSingleTransaction(transactionType: String) = db.transactionDao().getAllSingleTransaction(transactionType)
}