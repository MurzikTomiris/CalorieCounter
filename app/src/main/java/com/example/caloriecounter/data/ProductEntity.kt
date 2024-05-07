package com.example.caloriecounter.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name : String,
    var brand : String,
    var category : String,
    var barcode : String,
    var portion : String,
    var serving_size : Float,
    var calories : Float,
    var fats : Float,
    var squirrels : Float,
    var carbohydrates : Float
){}
