package com.example.eq_hm_mobileapp_2023_version.data

data class MacrosState(
    var macroNo1: Macro = Macro(),
    var macroNo2: Macro = Macro(),
    var macroNo3: Macro = Macro(),
    var macroNo4: Macro = Macro(),
    var macroNo5: Macro = Macro(),
    var macroNo6: Macro = Macro(),
    var macroNo7: Macro = Macro(),
    var macroNo8: Macro = Macro(),
) {
    data class Macro(
        var progress: Float = 0.2f
    )
}