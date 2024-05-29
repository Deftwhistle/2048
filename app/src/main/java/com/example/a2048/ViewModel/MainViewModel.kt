package com.example.a2048.ViewModel

import android.annotation.SuppressLint
import android.widget.GridView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a2048.Model.DTO.GameState
import com.example.a2048.ViewModel.Service.EventToMovement
import com.example.a2048.ViewModel.Service.GeneratorGameByFunctions

@SuppressLint("ClickableViewAccessibility")
class MainViewModel:ViewModel() {
    private val _observableGameState: MutableLiveData<GameState> = MutableLiveData()
    val observableGameState: LiveData<GameState> get() = _observableGameState

    val gridView:GeneratorGameByFunctions = GeneratorGameByFunctions(4);
    init {
        _observableGameState.value = gridView.gameState
    }
    fun updateGameState(newGameState: GameState){
        _observableGameState.value = newGameState
    }
    override fun onCleared() {
        super.onCleared()
    }
}