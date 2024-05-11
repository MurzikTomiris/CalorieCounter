package com.example.caloriecounter.viewModel
import StoreUserId
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.caloriecounter.App
import com.example.caloriecounter.data.MainDb
import com.example.caloriecounter.toDate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.sql.Date
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
class MainViewModel(val database: MainDb, private val dataStore: DataStore<Preferences>) : ViewModel() {
    var userId: Int? = null
    init {
        viewModelScope.launch {
            StoreUserId(dataStore).getId.collect { id ->
                userId = id
            }
        }
    }

    var today: LocalDate = LocalDate.now()
    val selectedDate = Date.valueOf(today.toString())

    var caloriesConsumed = MutableStateFlow(0f)

    var norm = MutableStateFlow(userId?.let { database.userDao.getUserNormById(it) }!!)

    private val _consumedProducts = database.dailyMealDao.getDailyMeals(selectedDate)

    @RequiresApi(Build.VERSION_CODES.O)
    fun onPreviousDaySelected() {
        val previousDate = Date.valueOf(today.minusDays(1).toString())
        database.dailyMealDao.getDailyMeals(previousDate)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onNextDaySelected() {
        val nextDate = Date.valueOf(today.plusDays(1).toString())
        database.dailyMealDao.getDailyMeals(nextDate)
    }

    companion object{
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App).database
                val dataStore = (checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App).dataStore
                return UserViewModel(database, dataStore) as T
            }
        }
    }
}
