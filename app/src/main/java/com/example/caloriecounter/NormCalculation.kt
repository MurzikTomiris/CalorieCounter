package com.example.caloriecounter

import android.content.ContentValues.TAG
import android.util.Log
import com.example.caloriecounter.data.UserEntity

private const val TAG = "NormCalculation"

fun NormCalculation(user: UserEntity): Float {
    var norm: Float = if(user.gender == "female"){
        655.1f + (9.563f * user.weight) + (1.85f * user.height) - (4.676f * user.age)
    } else {
        66.5f + (13.75f * user.weight) + (5.003f * user.height) - (6.775f * user.age)
    }
    if (user.activityLevel == "low") {
        norm *= 1.2f
    } else if (user.activityLevel == "medium") {
        norm *= 1.55f
    } else {
        norm *= 1.7f
    }
    if (user.goal == "weight loss") {
        norm *= 0.85f
    } else if (user.goal == "keep weight") {
        norm *= 1
    } else {
        norm *= 1.15f
    }

    Log.d(TAG, "Norm for ${user.name} is $norm")

    return norm
}

/*enum class Gender(val value: String) {
    Male("male"),
    Female("female")
}

enum class Goal(val value: String) {
    Loss("weight loss"),
    Keep("keep weight"),
    Gain("weight gain")
}

enum class ActivityLevel(val value: String) {
    Low("low"),
    Medium("medium"),
    High("high")
}*/