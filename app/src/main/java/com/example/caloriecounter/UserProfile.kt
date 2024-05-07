package com.example.caloriecounter

import android.util.Log
import com.example.caloriecounter.data.UserEntity

private const val TAG = "UserProfile"

class UserProfile(
    val name: String,
    var gender: Gender,
    val goal: Goal,
    val activityLevel: ActivityLevel,
    val age: Int = 0,
    val weight: Float = 0f,
    val height: Int = 0,
    var norm: Float = 1800f,
){
    fun NormCalculation(user: UserProfile): Float {
        var norm: Float = if(user.gender == Gender.Female){
            655.1f + (9.563f * user.weight) + (1.85f * user.height) - (4.676f * user.age)
        } else {
            66.5f + (13.75f * user.weight) + (5.003f * user.height) - (6.775f * user.age)
        }
        if (user.activityLevel == ActivityLevel.Low) {
            norm *= 1.2f
        } else if (user.activityLevel == ActivityLevel.Medium) {
            norm *= 1.55f
        } else {
            norm *= 1.7f
        }
        /*1,2 – минимальный (сидячая работа, отсутствие физических нагрузок);
        1,375 – низкий (тренировки не менее 20 мин 1-3 раза в неделю);
        1,55 – умеренный (тренировки 30-60 мин 3-4 раза в неделю);
        1,7 – высокий (тренировки 30-60 мин 5-7 раза в неделю; тяжелая физическая работа);*/
        if (user.goal == Goal.Loss) {
            norm *= 0.85f
        } else if (user.goal == Goal.Keep) {
            norm *= 1
        } else {
            norm *= 1.15f
        }

        Log.d(TAG, "Norm for ${user.name} is $norm")

        return norm
    }
}

enum class Gender(val value: String) {
    Male("male"),
    Female("female")
}

enum class Goal(val value: String) {
    Loss("weight loss"),
    Keep("weight"),
    Gain("weight gain")
}

enum class ActivityLevel(val value: String) {
    Low("low"),
    Medium("medium"),
    High("high")
}