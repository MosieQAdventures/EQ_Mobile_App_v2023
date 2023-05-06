package com.example.eq_hm_mobileapp_2023_version.components


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.StrokeCap
import com.example.eq_hm_mobileapp_2023_version.theme.colorPalette
import com.example.eq_hm_mobileapp_2023_version.ui.MacrosUIState
import com.example.eq_hm_mobileapp_2023_version.ui.MacrosViewModel

@Composable
fun Macro(name: String, number: Int, macrosViewModel: MacrosViewModel, macrosUIState: MacrosUIState) {
    Column() {
        Card(
            elevation = 4.dp,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(2.dp)) {
                    Text(text = "$name $number", fontSize = 20.sp)
                }

                Arc(macroNumber = number, macrosViewModel = macrosViewModel, macrosUIState = macrosUIState)
            }
        }
    }
}

@Composable
fun Arc(macroNumber: Int, macrosViewModel: MacrosViewModel, macrosUIState: MacrosUIState) {
    //Icon(imageVector = Icons.Rounded.Refresh, contentDescription = null, Modifier.size(80.dp))

    var _progressVM = 0.2f
    var _progressUIS = 0.2f
    when (macroNumber) {
        1 -> {
            var progressVM = macrosViewModel.getMacro1Progress()
            var progressUIS by remember { mutableStateOf(macrosUIState.macroStateNo1) }
            _progressVM = progressVM
            _progressUIS = progressUIS
        }
        2 -> {
            var progressVM = macrosViewModel.getMacro2Progress()
            var progressUIS by remember { mutableStateOf(macrosUIState.macroStateNo2) }
            _progressVM = progressVM
            _progressUIS = progressUIS
        }
        3 -> {
            var progressVM = macrosViewModel.getMacro3Progress()
            var progressUIS by remember { mutableStateOf(macrosUIState.macroStateNo3) }
            _progressVM = progressVM
            _progressUIS = progressUIS
        }
        4 -> {
            var progressVM = macrosViewModel.getMacro4Progress()
            var progressUIS by remember { mutableStateOf(macrosUIState.macroStateNo4) }
            _progressVM = progressVM
            _progressUIS = progressUIS
        }
        5 -> {
            var progressVM = macrosViewModel.getMacro5Progress()
            var progressUIS by remember { mutableStateOf(macrosUIState.macroStateNo5) }
            _progressVM = progressVM
            _progressUIS = progressUIS
        }
        6 -> {
            var progressVM = macrosViewModel.getMacro6Progress()
            var progressUIS by remember { mutableStateOf(macrosUIState.macroStateNo6) }
            _progressVM = progressVM
            _progressUIS = progressUIS
        }
        7 -> {
            var progressVM = macrosViewModel.getMacro7Progress()
            var progressUIS by remember { mutableStateOf(macrosUIState.macroStateNo7) }
            _progressVM = progressVM
            _progressUIS = progressUIS
        }
        8 -> {
            var progressVM = macrosViewModel.getMacro8Progress()
            var progressUIS by remember { mutableStateOf(macrosUIState.macroStateNo8) }
            _progressVM = progressVM
            _progressUIS = progressUIS
        }
        else -> { //shouldn't happen
            var progressVM = macrosViewModel.getMacro1Progress()
            var progressUIS by remember { mutableStateOf(macrosUIState.macroStateNo1) }
            _progressVM = progressVM
            _progressUIS = progressUIS
        }
    }

    CircularSlider(
        modifier = Modifier.size(96.dp),
        padding = 25f,
        stroke = 18f,
        progressColor = colorPalette.primaryVariant,
        thumbColor = colorPalette.primaryVariant,
        backgroundColor = colorPalette.secondaryVariant,
        cap = StrokeCap.Round,
        touchStroke = 150f,
    ){
        //var progressValue = (it*100).toInt()
        //Log.d("progress","$macroNumber $progressValue")

        _progressUIS = it

        when (macroNumber) {
            1 -> macrosViewModel.changeMacro1Value(_progressUIS)
            2 -> macrosViewModel.changeMacro2Value(_progressUIS)
            3 -> macrosViewModel.changeMacro3Value(_progressUIS)
            4 -> macrosViewModel.changeMacro4Value(_progressUIS)
            5 -> macrosViewModel.changeMacro5Value(_progressUIS)
            6 -> macrosViewModel.changeMacro6Value(_progressUIS)
            7 -> macrosViewModel.changeMacro7Value(_progressUIS)
            8 -> macrosViewModel.changeMacro8Value(_progressUIS)
        }

        macrosViewModel.onMacroChangeStateUpdate()
    }


    var valueVM = _progressVM
    valueVM *= 100
    var valueVmStr = String.format("%.0f", valueVM)

    PercentValue(value = valueVmStr)
}

@Composable
fun PercentValue(value: String) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp)) {
        Text(text =  "$value %", fontSize = 16.sp)
    }
}