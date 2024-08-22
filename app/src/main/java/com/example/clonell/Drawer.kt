package com.example.clonell

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CustomDrawer() {
    LazyColumn (modifier = Modifier.padding(top = 30.dp)) {
        item(10) {
            repeat(10) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        BadgedBox(badge = {
                            Badge(
                                containerColor = androidx.compose.ui.graphics.Color.Red,
                                contentColor = androidx.compose.ui.graphics.Color.White
                            ) {
                                Text(text = "Hi")
                            }
                        }) {
                            Icon(imageVector = Icons.Filled.Email, contentDescription = "email")
                        }
                        Text(text = "Nihao ma")
                    }
                }
                Spacer(modifier = Modifier.padding(5.dp))
            }
        }
    }
}

