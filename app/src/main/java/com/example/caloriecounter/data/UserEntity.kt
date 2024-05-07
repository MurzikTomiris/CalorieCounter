package com.example.caloriecounter.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.caloriecounter.ActivityLevel
import com.example.caloriecounter.Gender
import com.example.caloriecounter.Goal

@Entity(tableName = "user")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String,
    var gender: String,
    var goal: String,
    var activityLevel: String,
    var age: Int = 0,
    var weight: Float = 0f,
    var height: Int = 0,
    var norm: Float = 1800f,
){
}

