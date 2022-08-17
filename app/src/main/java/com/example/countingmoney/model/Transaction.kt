package com.example.countingmoney.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val title: String,
    var image: Int? = null,
    val amount: Double,
    val transaction_type: String,
    val category: String,
    val time: String,
    val description: String
    ) : Serializable
