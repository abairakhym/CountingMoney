package com.example.countingmoney.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.countingmoney.model.Transaction

@Database(entities = arrayOf(Transaction::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao() : TransactionDao
}