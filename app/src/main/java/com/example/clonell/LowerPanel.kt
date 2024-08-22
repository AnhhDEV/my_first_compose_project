package com.example.clonell

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LowerPanel(navController: NavController) {
    LazyColumn {
        items(DishRepository.dishes) {
            DishDescription(dish = it, navController = navController)
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}

@Composable
fun DishDescription(dish: Dish, navController: NavController) {
    Card (modifier = Modifier.fillMaxWidth().clickable {
        navController.navigate(Detail.route + "/${dish.id}")
    }) {
        Column {
            Text(text = dish.name)
            Row {
                Text(text = dish.description, modifier = Modifier.width(250.dp))
                val bitmap = BitmapFactory.decodeResource(
                    LocalContext.current.resources,
                    dish.imageResources,
                    BitmapFactory.Options().apply {
                        inSampleSize = 4
                    }
                ).asImageBitmap()
                Image(bitmap = bitmap, contentDescription = "hi")
            }
            Text(text = "$${dish.price}")
        }
    }
}