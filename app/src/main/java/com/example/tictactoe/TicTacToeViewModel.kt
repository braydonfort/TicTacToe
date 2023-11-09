package com.example.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TicTacToeViewModel: ViewModel() {

    var isGameOver by mutableStateOf(false)

    var winner by mutableStateOf("")

    var board by mutableStateOf(arrayListOf("", "", "", "", "", "", "", "", ""))

    val currentPlayer = mutableStateOf("X") //Whos turn it currently is set to X by default
    private var playerX = "X"
    private var playerO = "O"


    fun play(move: Int) {
        if (isGameOver) return

        // TODO Write the logic for when a user clicks on one of the available TicTacToe spaces

    }

    /**
     * Resets the game
     * */
    fun reset() {
        // TODO Write the logic for resetting the board state to its default settings
    }

    /**
     * Determine if the board is full
     * */
    fun isBoardFull(board: ArrayList<String>): Boolean {
        return TODO("Fill in the logic for determining if there are no more moves to make")
    }
    /**
     * Determines if the game is won
     * */
    fun isGameWon(board: ArrayList<String>, player: String): Boolean =
        // The array containing the moves the players have made can be visualized as:
        // [0][1][2]
        // [3][4][5]
        // [6][7][8]
        // so, if player x has made a move in boxes 0, 3, and 6 that would mean that they have won.

        //check rows
        if (board[0] == player && board[1] == player && board[2] == player) true
        // TODO check other two rows

        //check columns
        else if (board[0] == player && board[3] == player && board[6] == player) true
        // TODO Check other two columns

        //check diagonals
        // TODO Check other diagonal
        else board[0] == player && board[4] == player && board[8] == player

    /**
     * Method for returning a string for the result of the game
     * */
    fun gameResult(board: ArrayList<String>): String {
        when {
            isGameWon(board, playerX) -> return "PLAYER X Won"
            isGameWon(board, playerO) -> return "PLAYER O Won"
            isBoardFull(board) -> return "It is Tie"
        }
        return "Tie"
    }


}


