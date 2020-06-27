package com.example.tictactoeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        val btnSelected = view as Button

        var cellId = 0
        when (btnSelected) {
            btn1 -> cellId = 1
            btn2 -> cellId = 2
            btn3 -> cellId = 3
            btn4 -> cellId = 4
            btn5 -> cellId = 5
            btn6 -> cellId = 6
            btn7 -> cellId = 7
            btn8 -> cellId = 8
            btn9 -> cellId = 9
        }
        buttonClicked ++
        playGame(btnSelected, cellId)
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var buttonClicked = 0

    private fun playGame(btnSelected: Button, cellId: Int) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.color.green)
            player1.add(cellId)
            activePlayer = 2
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundResource(R.color.red)
            player2.add(cellId)
            activePlayer = 1
        }
        btnSelected.isEnabled = false

        checkWinner()
    }

    fun checkWinner() {
        var winner = -1
        //row
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1

        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        //col
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
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
