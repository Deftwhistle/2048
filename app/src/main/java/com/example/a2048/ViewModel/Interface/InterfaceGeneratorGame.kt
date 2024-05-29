package com.example.a2048.ViewModel.Interface

import android.content.Context
import android.widget.GridView
import android.widget.TextView
import com.example.a2048.Model.DTO.GameState

interface InterfaceGeneratorGame{
    val columns: Int
    fun generatorBoard(context: Context):GridView

}