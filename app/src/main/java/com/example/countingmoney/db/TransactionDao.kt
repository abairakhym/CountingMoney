package com.example.countingmoney.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.countingmoney.model.Transaction

@Dao
interface TransactionDao {
    //used to insert new transaction
    @Insert
    suspend fun insertTransaction(transaction: Transaction) //vararg transaction: Transaction

    //used to delete transaction
    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    //used to update transaction
    @Update
    suspend fun updateTransaction(transaction: Transaction)

    //used for get all transaction
    @Query("SELECT * from transactions")
    fun getAllTransaction(): LiveData<List<Transaction>>

    //get income or expense list transaction
    @Query("SELECT * from transactions WHERE transaction_type == :transaction_type")
    fun getAllSingleTransaction(transaction_type: String): LiveData<List<Transaction>>
}