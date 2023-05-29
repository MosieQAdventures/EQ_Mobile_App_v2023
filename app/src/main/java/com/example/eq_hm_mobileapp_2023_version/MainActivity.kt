package com.example.eq_hm_mobileapp_2023_version

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eq_hm_mobileapp_2023_version.components.Macro
import com.example.eq_hm_mobileapp_2023_version.theme.EQ_HM_MobileApp_2023_VersionTheme
import com.example.eq_hm_mobileapp_2023_version.theme.colorPalette
import com.example.eq_hm_mobileapp_2023_version.ui.MacrosViewModel
import com.example.eq_hm_mobileapp_2023_version.vstSend.ProgressDescription
import com.example.eq_hm_mobileapp_2023_version.vstSend.Singleton
import java.util.ArrayList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileApp()
        }
    }
}

@Composable
fun MobileApp() {
    val activity = (LocalContext.current as Activity) // see if it works, if not move down
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    // Singleton stuff start
    // init and set list of params to send
    var progressDescriptions: MutableList<ProgressDescription?> = ArrayList()
    progressDescriptions = createProgressList(progressDescriptions)

    Singleton.getInstance().setProgressDescriptionList(progressDescriptions)
    //Singleton stuff end

    EQ_HM_MobileApp_2023_VersionTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            Scaffold() {
                Box() {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxSize()
                    ) {
                        FourItemRow(1)
                        FourItemRow(5)
                    }

                    Box(modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.TopEnd)) {
                        Card(
                            elevation = 4.dp,
                            modifier = Modifier.padding(4.dp),
                        ) {
                            Button(
                                colors = ButtonDefaults.buttonColors(colorPalette.background),
                                //border = BorderStroke(1.dp, colorPalette.onBackground),
                                onClick = { Log.d("Button", "clocked") }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Settings,
                                    contentDescription = null,
                                    Modifier
                                        .size(36.dp)
                                        .padding(0.dp),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FourItemRow(number: Int) {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        MacroHolder( name = "Macro ", number = (number+0) )
        MacroHolder( name = "Macro ", number = (number+1) )
        MacroHolder( name = "Macro ", number = (number+2) )
        MacroHolder( name = "Macro ", number = (number+3) )
    }
}

@Composable
fun MacroHolder(name: String, number: Int,
                macrosViewModel: MacrosViewModel = viewModel()) {
    val macrosUIState by macrosViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Macro(
            name = name,
            number = number,
            macrosViewModel = macrosViewModel,
            macrosUIState = macrosUIState,
        )
    }
}

//default values
fun createProgressList(progressList: MutableList<ProgressDescription?>): MutableList<ProgressDescription?> {
    progressList.add(ProgressDescription("m1p", 0.2f)) //0-19980        //index 0
    progressList.add(ProgressDescription("m2p", 0.2f)) //0-3           //index 1
    progressList.add(ProgressDescription("m3p", 0.2f)) //0-19980      //index 2
    progressList.add(ProgressDescription("m4p", 0.2f)) //0-489       //index 3
    progressList.add(ProgressDescription("m5p", 0.2f)) //0-99         //index 4
    progressList.add(ProgressDescription("m6p", 0.2f)) //0-19980      //index 5
    progressList.add(ProgressDescription("m7p", 0.2f)) //0-489       //index 6
    progressList.add(ProgressDescription("m8p", 0.2f)) //0-99         //index 7
    return progressList
}

@Composable
fun TestText(name: String) {
    Text(text = name)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EQ_HM_MobileApp_2023_VersionTheme {
        TestText("Preview")
    }
}