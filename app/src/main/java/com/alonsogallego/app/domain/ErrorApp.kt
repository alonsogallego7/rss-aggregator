package com.alonsogallego.app.domain

sealed class ErrorApp {
    class DataError() : ErrorApp()
}