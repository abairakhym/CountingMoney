package com.example.countingmoney.utils

import com.example.countingmoney.model.Transaction

sealed class ViewState {
    object Loading: ViewState()
    data class Success(val transaction: List<Transaction>): ViewState()
    data class Error(val exception: Throwable): ViewState()
}