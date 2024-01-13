package com.example.data.di

sealed interface GeneralError {
    object Server : GeneralError
    object Connectivity : GeneralError
    object Unknown : GeneralError
}