package com.example.caloriecounter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.caloriecounter.viewModel.MainViewModel
import com.example.caloriecounter.viewModel.UserViewModel

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(factory = UserViewModel.factory),
) {
    val selectedDate = viewModel.selectedDate

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                        Text(text = selectedDate.toString())
                },
                navigationIcon = {
                    IconButton(onClick = { viewModel.onPreviousDaySelected() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Previous Day")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.onNextDaySelected() }) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Next Day")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                        label = { Text("Profile") },
                        selected = false,
                        onClick = { /* Handle profile navigation */ }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.DateRange, contentDescription = "Statistics") },
                        label = { Text("Statistics") },
                        selected = false,
                        onClick = { /* Handle statistics navigation */ }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Add, contentDescription = "Add Product") },
                        label = { Text("Add Product") },
                        selected = false,
                        onClick = { /* Handle adding product navigation */ }
                    )

            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val caloriesConsumed by viewModel.caloriesConsumed.collectAsState()
            val norm by viewModel.norm.collectAsState()

            //ProgressBlock(caloriesConsumed, norm)
            ProgressBlock(1200f, 1600f)
            Spacer(modifier = Modifier.height(20.dp))

            /*LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(viewModel.consumedProducts) { product ->
                    ProductCard(product)
                }*/
            }
        }
    }


@Composable
fun ProgressBlock(caloriesConsumed: Float, norm: Float) {
    val progress = if (norm != 0f) caloriesConsumed / norm else 0f

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$caloriesConsumed / $norm ккал",
            modifier = Modifier.padding(8.dp),
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
        ) {
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Green
            )
        }
    }
}

