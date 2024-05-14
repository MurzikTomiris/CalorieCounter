package com.example.caloriecounter.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(userEntity: UserEntity) {
        userDao.insertUpdUser(userEntity)
    }

    suspend fun deleteUser(userEntity: UserEntity) {
        userDao.deleteUser(userEntity)
    }

    suspend fun getAllUsers() = withContext(Dispatchers.IO) {
        userDao.getAllUsers()
    }

    fun getUserById(id: Int): UserEntity {
        return userDao.getUserById(id)
    }

    fun getUserNormById(id: Int): Float {
        return userDao.getUserNormById(id)
    }
}