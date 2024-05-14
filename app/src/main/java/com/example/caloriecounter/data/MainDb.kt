package com.example.caloriecounter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.caloriecounter.Converters

@Database(
    entities = [UserEntity::class, ProductEntity::class, MealEntity::class, DailyMeal::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MainDb: RoomDatabase() {
    abstract val userDao: UserDao
    abstract val productDao: ProductDao
    abstract val mealDao: MealDao
    abstract val dailyMealDao: DailyMealDao
    /*companion object{
        fun createDataBase(context: Context): MainDb{
            return Room.databaseBuilder(
                context,
                MainDb::class.java,
                "caloriecounter.db"
            ).build()
        }
    }*/
    companion object{
        @Volatile
        private var INSTANCE: MainDb? = null

        fun createDataBase(context: Context): MainDb {
            return INSTANCE ?:synchronized(this){
                val instance: MainDb = Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = MainDb::class.java,
                    name = "caloriecounter.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}