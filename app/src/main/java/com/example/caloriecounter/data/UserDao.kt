package com.example.caloriecounter.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdUser(userEntity: UserEntity)

    @Delete
    suspend fun deleteUser(userEntity: UserEntity)

    @Query("select * from user")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Query("select * from user WHERE id = :id")
    fun getUserById (id: Int): UserEntity

    @Query("select norm from user WHERE id = :id")
    fun getUserNormById (id: Int): Float
}