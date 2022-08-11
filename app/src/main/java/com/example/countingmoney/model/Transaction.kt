package com.example.countingmoney.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val amount: Double,
    val transaction_type: String,
    val category: String,
    val time: String,
    val description: String)
