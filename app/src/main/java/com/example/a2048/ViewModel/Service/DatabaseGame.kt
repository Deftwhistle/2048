package com.example.a2048.ViewModel.Service

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.a2048.Model.DTO.GameState
import com.example.a2048.Model.DTO.State
import com.example.a2048.ViewModel.MainViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.values

class DatabaseGame {



    fun saveGameState(gameState: State) {
        // Obtén una referencia a la base de datos

        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef: DatabaseReference = database.getReference("gameState")

        // Guarda el objeto GameState en la base de datos
        myRef.setValue(gameState).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.e("SAVE STATE","GameState guardado exitosamente.")
            } else {
                Log.e("SAVE STATE","Error al guardar GameState: ${task.exception?.message}")
            }
        }
    }


    fun loadGameState(context: Context, mainViewModel: MainViewModel): String{


         var mainViewModel_: MainViewModel = mainViewModel
         lateinit var state : GameState

        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef: DatabaseReference = database.getReference("gameState")
        var value : String = "test"


        myRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.w("DATABASE_ERROR", "Error while reading appointments", error.toException())
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                myRef.get().addOnSuccessListener {
                    state = it.getValue<GameState>() as GameState
                    //value = it.value.toString()
                    mainViewModel_.updateGameState(state)
                    //Toast.makeText(context,value,Toast.LENGTH_LONG).show()
                }.addOnFailureListener{
                    value = "Error getting data"

                    Toast.makeText(context,value,Toast.LENGTH_LONG).show()
                }

            }

        })

        return value
    }

}