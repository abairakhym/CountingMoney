package com.example.countingmoney.db

import androidx.room.*
import com.example.countingmoney.model.Transaction

@Dao
interface TransactionDao {
    //used to insert new transaction
    @Insert
    fun insertTransaction(transaction: Transaction) //vararg transaction: Transaction

    //used to delete transaction
    @Delete
    fun deleteTransaction(transaction: Transaction)

    //used to update transaction
    @Update
    fun updateTransaction(transaction: Transaction)

    //used for get all transaction
    @Query("SELECT * from transactions")
    fun getAllTransaction(): List<Transaction>

    //get income or expense list transaction
    @Query("SELECT * from transactions WHERE transaction_type == :transaction_type")
    fun getAllSingleTransaction(transaction_type: String): List<Transaction>
}