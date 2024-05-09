package com.example.caloriecounter

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.caloriecounter.data.MainDb

class App: Application() {
    val dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")
    val database by lazy{ MainDb.createDataBase(this)}
}