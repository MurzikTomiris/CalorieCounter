package com.example.caloriecounter

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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.caloriecounter.viewModel.UserViewModel
import com.example.caloriecounter.viewModel.UserViewModel.Companion as UserViewModel1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateUser(
    userViewModel: UserViewModel = viewModel(factory = UserViewModel1.factory),
) {
    /*var gender: String by remember { mutableStateOf("female") }
    var goal: String by remember { mutableStateOf("weight loss") }
    var activityLevel: String by remember { mutableStateOf("low") }*/

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Ваш профиль:",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = userViewModel.nameText.value,
            onValueChange = { userViewModel.nameText.value = it },
            label = { Text(text = "Введите имя")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = userViewModel.ageText.value,
            onValueChange = { userViewModel.ageText.value = it },
            label = { Text(text = "Возраст")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = userViewModel.weightText.value,
            onValueChange = { userViewModel.weightText.value = it },
            label = { Text(text = "Вес")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = userViewModel.heightText.value,
            onValueChange = { userViewModel.heightText.value = it },
            label = { Text(text = "Рост")},
            modifier = Modifier
                .fillMaxWidth()
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
                colors = ButtonDefaults.buttonColors(if (userViewModel.genderText.value == "female") Color.DarkGray else Color.Gray),
                onClick = {
                    userViewModel.genderText.value = "female"
                }
            ) {
                Text(text = "Женщина")
            }
            Button(
                modifier = Modifier
                    .padding(10.dp)
                    .height(IntrinsicSize.Min),
                colors = ButtonDefaults.buttonColors(if (userViewModel.genderText.value == "male") Color.DarkGray else Color.Gray),
                onClick = {
                    userViewModel.genderText.value = "male"
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
                colors = ButtonDefaults.buttonColors(if (userViewModel.goalText.value == "weight loss") Color.DarkGray else Color.Gray),
                onClick = {
                    userViewModel.goalText.value = "weight loss"
                }
            ) {
                Text(text = "Похудеть", textAlign = TextAlign.Center)
            }
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .height(IntrinsicSize.Min)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(if (userViewModel.goalText.value == "keep weight") Color.DarkGray else Color.Gray),
                onClick = {
                    userViewModel.goalText.value = "keep weight"
                }
            ) {
                Text(text = "Сохранить вес", textAlign = TextAlign.Center)
            }
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .height(IntrinsicSize.Min)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(if (userViewModel.goalText.value == "weight gain") Color.DarkGray else Color.Gray),
                onClick = {
                    userViewModel.goalText.value = "weight gain"
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
                colors = ButtonDefaults.buttonColors(if (userViewModel.activityLevelText.value == "low") Color.DarkGray else Color.Gray),
                onClick = {
                    userViewModel.activityLevelText.value = "low"
                }
            ) {
                Text(text = "Низкая", textAlign = TextAlign.Center)
            }
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .height(IntrinsicSize.Min)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(if (userViewModel.activityLevelText.value == "medium") Color.DarkGray else Color.Gray),
                onClick = {
                    userViewModel.activityLevelText.value = "medium"
                }
            ) {
                Text(text = "Средняя", textAlign = TextAlign.Center)
            }
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .height(IntrinsicSize.Min)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(if (userViewModel.activityLevelText.value == "high") Color.DarkGray else Color.Gray),
                onClick = {
                    userViewModel.activityLevelText.value = "high"
                }
            ) {
                Text(text = "Высокая", textAlign = TextAlign.Center)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            userViewModel.insertUser()
        }) {
            Text(text = "Сохранить", textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = userViewModel.userId.toString(),
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

}