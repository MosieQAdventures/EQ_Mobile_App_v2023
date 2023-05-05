package com.example.eq_hm_mobileapp_2023_version

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eq_hm_mobileapp_2023_version.components.Macro
import com.example.eq_hm_mobileapp_2023_version.ui.theme.EQ_HM_MobileApp_2023_VersionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EQ_HM_MobileApp_2023_VersionTheme {
                val activity = (LocalContext.current as Activity)
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) { 
                    Scaffold() {
                        Column(
                            modifier = Modifier.padding(12.dp).fillMaxSize()
                        ) {
                            FourItemRow(1)
                            FourItemRow(5)
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
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp).fillMaxWidth(),
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
fun MacroHolder(name: String, number: Int) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Macro(name = name, number = number)
    }
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