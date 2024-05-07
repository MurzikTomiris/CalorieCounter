package com.example.caloriecounter.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdMeal(mealEntity: MealEntity)

    @Delete
    suspend fun deleteMeal(mealEntity: MealEntity)

    @Query("select * from meal")
    fun getAllMeals(): Flow<List<MealEntity>>
}