package com.example.caloriecounter.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "meal",
    foreignKeys = [
        ForeignKey(entity = ProductEntity::class, parentColumns = ["id"], childColumns = ["productId"])
    ])
data class MealEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name : String,
    var productId : Int,
    var quantity : Float,
    var mealCalories : Float,
    var mealFats : Float,
    var mealSquirrels : Float,
    var mealCarbohydrates : Float,
){
}