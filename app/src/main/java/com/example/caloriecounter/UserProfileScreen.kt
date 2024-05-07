package com.example.caloriecounter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateUser() {

    var gender: Gender by remember { mutableStateOf(Gender.Female) }
    var goal: Goal by remember { mutableStateOf(Goal.Loss) }
    var activityLevel: ActivityLevel by remember { mutableStateOf(ActivityLevel.Low) }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Добро пожаловать в приложение CalorieCounter!",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = "",
            onValueChange = {  },
            label = { Text(text = "Введите имя")},
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = "",
            onValueChange = {  },
            label = { Text(text = "Возраст")},
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = "",
            onValueChange = {  },
            label = { Text(text = "Вес")},
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = "",
            onValueChange = {  },
            label = { Text(text = "Рост")},
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Ваш пол:",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .padding(10.dp)
                    .height(IntrinsicSize.Min),
                colors = ButtonDefaults.buttonColors(if (gender == Gender.Female) Color.DarkGray else Color.Gray),
                onClick = {
                    gender = Gender.Female
                }
            ) {
                Text(text = "Женщина")
            }
            Button(
                modifier = Modifier
                    .padding(10.dp)
                    .height(IntrinsicSize.Min),
                colors = ButtonDefaults.buttonColors(if (gender == Gender.Male) Color.DarkGray else Color.Gray),
                onClick = {
                    gender = Gender.Male
                }
            ) {
                Text(text = "Мужчина")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Ваша цель:",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .height(IntrinsicSize.Min)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(if (goal == Goal.Loss) Color.DarkGray else Color.Gray),
                onClick = {
                    goal = Goal.Loss
                }
            ) {
                Text(text = "Похудеть", textAlign = TextAlign.Center)
            }
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .height(IntrinsicSize.Min)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(if (goal == Goal.Keep) Color.DarkGray else Color.Gray),
                onClick = {
                    goal = Goal.Keep
                }
            ) {
                Text(text = "Сохранить вес", textAlign = TextAlign.Center)
            }
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .height(IntrinsicSize.Min)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(if (goal == Goal.Gain) Color.DarkGray else Color.Gray),
                onClick = {
                    goal = Goal.Gain
                }
            ) {
                Text(text = "Набрать вес", textAlign = TextAlign.Center)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Ваша активность:",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .height(IntrinsicSize.Min)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(if (activityLevel == ActivityLevel.Low) Color.DarkGray else Color.Gray),
                onClick = {
                    activityLevel = ActivityLevel.Low
                }
            ) {
                Text(text = "Низкая", textAlign = TextAlign.Center)
            }
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .height(IntrinsicSize.Min)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(if (activityLevel == ActivityLevel.Medium) Color.DarkGray else Color.Gray),
                onClick = {
                    activityLevel = ActivityLevel.Medium
                }
            ) {
                Text(text = "Средняя", textAlign = TextAlign.Center)
            }
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .height(IntrinsicSize.Min)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(if (activityLevel == ActivityLevel.High) Color.DarkGray else Color.Gray),
                onClick = {
                    activityLevel = ActivityLevel.High
                }
            ) {
                Text(text = "Высокая", textAlign = TextAlign.Center)
            }
        }
    }

}