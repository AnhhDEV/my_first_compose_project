package com.example.clonell

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clonell.ui.theme.PurpleGrey40
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun UpperPanel(snackBarHostState: SnackbarHostState, scope: CoroutineScope) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = PurpleGrey40)) {
        Text(text = stringResource(id = R.string.app_name))
        Row {
            Text(
                text = stringResource(id = R.string.description),
                modifier = Modifier.width(200.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "banner",
                modifier = Modifier.clip(RoundedCornerShape(30.dp))
            )
        }
        Button(onClick = {
            scope.launch {
                snackBarHostState.showSnackbar(
                    "This is snackbar",
                    duration = SnackbarDuration.Short
                )
            }
        }) {
            Text(text = stringResource(id = R.string.order_button_text))
        }
    }
}