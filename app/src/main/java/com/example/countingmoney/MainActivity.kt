package com.example.countingmoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.countingmoney.db.AppDatabase
import com.example.countingmoney.repo.TransactionRepository
import com.example.countingmoney.view.TransactionViewModel
import com.example.countingmoney.view.TransactionsViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TransactionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transactionsRepository = TransactionRepository(AppDatabase(this))
        val viewModelProviderFactory = TransactionsViewModelProviderFactory(transactionsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(TransactionViewModel::class.java)
    }
}