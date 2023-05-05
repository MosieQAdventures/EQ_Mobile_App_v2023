package com.example.eq_hm_mobileapp_2023_version.components


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.StrokeCap
import com.example.eq_hm_mobileapp_2023_version.ui.theme.colorPalette

@Composable
fun Macro(name: String) {
    Column() {
        Card(
            elevation = 4.dp,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(2.dp)) {
                    Text(text = name, fontSize = 20.sp)
                }

                Arc()

                PercentValue(value = 20)
            }
        }
    }
}

@Composable
fun Arc() {
    //Icon(imageVector = Icons.Rounded.Refresh, contentDescription = null, Modifier.size(80.dp))

    CircularSlider(
        modifier = Modifier.size(96.dp),
        padding = 25f,
        stroke = 18f,
        progressColor = colorPalette.primaryVariant,
        thumbColor = colorPalette.primaryVariant,
        backgroundColor = colorPalette.secondaryVariant,
        cap = StrokeCap.Round,
        touchStroke = 125f,

    ){
        var progressValue = (it*100).toInt()

        Log.d("progress",progressValue.toString() + " %")
    }
}

@Composable
fun PercentValue(value: Int) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 2.dp)) {
        Text(text =  "$value %", fontSize = 16.sp)
    }
}