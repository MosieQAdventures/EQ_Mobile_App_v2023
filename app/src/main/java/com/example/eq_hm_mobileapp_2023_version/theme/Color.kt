package com.example.eq_hm_mobileapp_2023_version.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Red400 = Color(0xFFCF6679)

//ColorPalette
/*
    <color name="EQHM_light_grey">#FF3F3F3F</color>
    <color name="EQHM_dark_red">#FF791B1B</color>
    <color name="EQHM_light_red">#FFA53838</color>
    <color name="EQHM_dark_grey">#FF1C1C1C</color>
    <color name="EQHM_black_needle">#FF191919</color>
*/
val LightGrey = Color(0xFFAAAAAA)
val MidGrey = Color(0xFF3F3F3F)
val DarkRed = Color(0xFF791B1B)
val LightRed = Color(0xFFA53838)
val DarkGrey = Color(0xFF1C1C1C)
val BlackNeedle = Color(0xFF191919)

internal val colorPalette: Colors = Colors(
    primary = LightRed,
    primaryVariant = DarkRed,
    secondary = LightGrey,
    secondaryVariant = MidGrey,
    error = Red400,
    onPrimary = DarkGrey,
    onSecondary = Color.Black,
    onError = Color.Black,

    background = DarkGrey,
    onBackground = LightGrey,
    isLight = false,
    surface = DarkGrey,
    onSurface = MidGrey
)