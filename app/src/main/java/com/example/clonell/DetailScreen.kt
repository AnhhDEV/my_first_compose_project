package com.example.clonell

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.CoroutineScope

@Composable
fun DetailScreen(id: Int) {
    val dish = requireNotNull(DishRepository.getDish(id))
    Column {
        Image(bitmap = BitmapFactory.decodeResource(
            LocalContext.current.resources,
            dish.imageResources,
            BitmapFactory.Options().apply {
                inSampleSize = 4
            }
        ).asImageBitmap(), contentDescription = dish.name)
        Text(text = dish.name)
        Text(text = dish.description)
        Counter()
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add for" + "$${dish.price}")
        }
    }
}

@Composable
fun Counter() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        var counter by rememberSaveable {
            mutableIntStateOf(0)
        }
        TextButton(onClick = { counter-- }) {
            Text(text = "-")
        }
        Text(text = "$counter")
        TextButton(onClick = { counter++ }) {
            Text(text = "+")
        }
    }
}