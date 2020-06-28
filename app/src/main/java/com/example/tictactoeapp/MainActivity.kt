package com.example.tictactoeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var noPlayer : Int = 0
    var activePlayer = 1
    var buttonClicked = 0

    var board = Array(3){Array(3){noPlayer} }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        val btnSelected = view as Button

        when (btnSelected) {
            btn1 -> board[0][0] =  activePlayer
            btn2 -> board[0][1] =  activePlayer
            btn3 -> board[0][2] =  activePlayer
            btn4 -> board[1][0] =  activePlayer
            btn5 -> board[1][1] =  activePlayer
            btn6 -> board[1][2] =  activePlayer
            btn7 -> board[2][0] =  activePlayer
            btn8 -> board[2][1] =  activePlayer
            btn9 -> board[2][2] =  activePlayer
        }
        buttonClicked ++
        playGame(btnSelected)
    }

    private fun playGame(btnSelected: Button) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.color.green)
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundResource(R.color.red)
        }
        btnSelected.isEnabled = false

        checkWinner()
        switchPlayer()


    }
    fun switchPlayer(){
        if(activePlayer == 1){
            activePlayer = 2
        }else{
            activePlayer = 1
        }
    }

    fun checkWinner() {
        var winner = -1

        //check row
        for(i in 0..2){
           if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
               winner = board[i][0]
               break
           }
        }

        //check col
        for(i in 0..2){
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                winner = board[1][i]
                break
            }
        }

        //check diagonal
        var aux = board[0][0]
        for(i in 1..2){
            if(aux != board[i][i])
            {
                break
            }
            if (i == 2) {
                winner = aux
            }
        }
        //check anti- diagonal
        aux = board[0][2]
        for(i in 1..2){
            if (board[i][2 -i] != aux) {
                break
            }
            if (i == 2) {
                winner = aux
            }
        }

        if (winner == 1) {
            Toast.makeText(this, "Player 1 wins", Toast.LENGTH_LONG).show()
            return
        } else if (winner == 2) {
            Toast.makeText(this, "Player 2 wins", Toast.LENGTH_LONG).show()
            return
        } else if (buttonClicked == 9) {
            Toast.makeText(this, "It's a drawn! Play again", Toast.LENGTH_LONG).show()
        }
    }
}
