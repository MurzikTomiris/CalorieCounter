package com.example.caloriecounter.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.caloriecounter.Converters
import java.sql.Date

@Entity(tableName = "daily_meal",
    foreignKeys = [
        ForeignKey(entity = UserEntity::class, parentColumns = ["id"], childColumns = ["userId"]),
        ForeignKey(entity = MealEntity::class, parentColumns = ["id"], childColumns = ["mealId"])
    ])
data class DailyMeal(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @TypeConverters(Converters::class)
    val date: Date,
    var userId : Int,
    var mealId : Int,
) {
}
