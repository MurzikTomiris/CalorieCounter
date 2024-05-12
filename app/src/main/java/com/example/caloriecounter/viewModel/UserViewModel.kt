package com.example.caloriecounter.viewModel

import StoreUserId
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.caloriecounter.App
import com.example.caloriecounter.NormCalculation
import com.example.caloriecounter.data.MainDb
import com.example.caloriecounter.data.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(val database: MainDb, private val dataStore: DataStore<Preferences>): ViewModel() {
    val userList = database.userDao.getAllUsers()
    private val storeUserId = StoreUserId(dataStore)

    val user : UserEntity? = null
    val nameText = mutableStateOf("")
    var genderText = mutableStateOf("")
    var goalText = mutableStateOf("")
    var activityLevelText = mutableStateOf("")
    var ageText = mutableStateOf("")
    var weightText = mutableStateOf("")
    var heightText = mutableStateOf("")
    var normText = mutableStateOf("")
    var userId: Int? = null

    init {
        viewModelScope.launch {
            storeUserId.getId.collect { id ->
                userId = id
            }
        }
    }

    fun insertUser() = viewModelScope.launch (Dispatchers.IO) {
        val userProfile = user?.copy(name = nameText.value,
                                    gender = genderText.value,
                                    goal = goalText.value,
                                    activityLevel = activityLevelText.value,
                                    age = ageText.value.toInt(),
                                    weight = weightText.value.toFloat(),
                                    height = heightText.value.toInt(),
                                    norm = normText.value.toFloat())
            ?: UserEntity(name = nameText.value,
                        gender = genderText.value,
                        goal = goalText.value,
                        activityLevel = activityLevelText.value,
                        age = ageText.value.toInt(),
                        weight = weightText.value.toFloat(),
                        height = heightText.value.toInt(),
                        norm = normText.value.toFloat())
        userId = userProfile.id ?: null
        userId?.let { storeUserId.saveId(it) }
        database.userDao.insertUpdUser(userProfile)
    }

    fun calculateAndUpdateNorm(user: UserEntity?) {
        user?.let {
            val norm = NormCalculation(user)
            normText.value = norm.toString()
        } ?: run {
            normText.value = "1800"
        }
    }

    companion object{
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                val dataStore = (checkNotNull(extras[APPLICATION_KEY]) as App).dataStore
                return UserViewModel(database, dataStore) as T
            }
        }
    }
}

