package com.example.caloriecounter.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.sql.Date

@Dao
interface DailyMealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdDailyMeal(dailyMeal: DailyMeal)

    @Delete
    suspend fun deleteDailyMeal(dailyMeal: DailyMeal)

    @Query("SELECT * FROM daily_meal JOIN meal ON meal.id = daily_meal.mealId WHERE date = :date")
    fun getDailyMeals(date: Date): Flow<List<DailyMeal>>
}
