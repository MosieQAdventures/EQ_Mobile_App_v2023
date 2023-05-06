package com.example.eq_hm_mobileapp_2023_version.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.eq_hm_mobileapp_2023_version.data.MacrosState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MacrosViewModel(
    private val state: MacrosState = MacrosState()
) : ViewModel() {

    private val _uiState = MutableStateFlow(MacrosUIState())
    val uiState: StateFlow<MacrosUIState> = _uiState.asStateFlow()

    fun changeMacro1Value(progress: Float) { state.macroNo1.progress = progress }
    fun getMacro1Progress() : Float { return state.macroNo1.progress }

    fun changeMacro2Value(progress: Float) { state.macroNo2.progress = progress }
    fun getMacro2Progress() : Float { return state.macroNo2.progress }

    fun changeMacro3Value(progress: Float) { state.macroNo3.progress = progress }
    fun getMacro3Progress() : Float { return state.macroNo3.progress }

    fun changeMacro4Value(progress: Float) { state.macroNo4.progress = progress }
    fun getMacro4Progress() : Float { return state.macroNo4.progress }

    fun changeMacro5Value(progress: Float) { state.macroNo5.progress = progress }
    fun getMacro5Progress() : Float { return state.macroNo5.progress }

    fun changeMacro6Value(progress: Float) { state.macroNo6.progress = progress }
    fun getMacro6Progress() : Float { return state.macroNo6.progress }

    fun changeMacro7Value(progress: Float) { state.macroNo7.progress = progress }
    fun getMacro7Progress() : Float { return state.macroNo7.progress }

    fun changeMacro8Value(progress: Float) { state.macroNo8.progress = progress }
    fun getMacro8Progress() : Float { return state.macroNo8.progress }

    fun onMacroChangeStateUpdate() {
        _uiState.update {
            MacrosUIState(
                macroStateNo1 = state.macroNo1.progress,
                macroStateNo2 = state.macroNo2.progress,
                macroStateNo3 = state.macroNo3.progress,
                macroStateNo4 = state.macroNo4.progress,
                macroStateNo5 = state.macroNo5.progress,
                macroStateNo6 = state.macroNo6.progress,
                macroStateNo7 = state.macroNo7.progress,
                macroStateNo8 = state.macroNo8.progress,
            )
        }

        Log.d("VM", "m3 ${_uiState.value.macroStateNo3}")
        //Log.d("VM", "m8 ${_uiState.value.macroStateNo8}")
    }


    init {

    }
}