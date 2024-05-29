package com.example.a2048.Model.DTO


import com.example.a2048.Model.Interface.InterfaceBoard
import java.util.LinkedList


data class GameState(
    var board: List<Int>,
    var score: Int,
    var best: Int
)

data class State(
    var board: List<Int>,
    var score: Int,
    var best: Int
)
