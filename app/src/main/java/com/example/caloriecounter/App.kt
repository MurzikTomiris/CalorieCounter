package com.example.caloriecounter

import android.app.Application
import com.example.caloriecounter.data.MainDb

class App: Application() {
    val database by lazy{ MainDb.createDataBase(this)}
}