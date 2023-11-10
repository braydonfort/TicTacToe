package com.example.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TicTacToeViewModel: ViewModel() {

    var isGameOver by mutableStateOf(false)

    var winner by mutableStateOf("")

    var board by mutableStateOf(arrayListOf("", "", "", "", "", "", "", "", ""))

    var currentPlayer by mutableStateOf("X") //Whos turn it currently is set to X by default
    private var playerX = "X"
    private var playerO = "O"


    fun play(move: Int) {
        if (isGameOver) return

        if (board[move] == "") {
            if (currentPlayer == playerX) {
                board = ArrayList(board.toMutableList().also {
                    it[move] = playerX
                })
                currentPlayer = playerO

            } else {
                board = ArrayList(board.toMutableList().also {
                    it[move] = playerO
                })
                currentPlayer = playerX

            }
        }

        // calculate and show game result
        isGameOver = isGameWon(board, playerX) || isGameWon(board, playerO) || isBoardFull(board)
        winner = gameResult(board)

    }

    /**
     * Resets the game
     * */
    fun reset() {
        isGameOver = false
        board = arrayListOf("", "", "", "", "", "", "", "", "")
        currentPlayer = playerX
    }

    /**
     * Determine if the board is full
     * */
    fun isBoardFull(board: ArrayList<String>): Boolean {
        for (i in board) {
            if (i != playerX && i != playerO) return false
        }
        return true
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
        else if (board[3] == player && board[4] == player && board[5] == player) true
        else if (board[6] == player && board[7] == player && board[8] == player) true

        //check columns
        else if (board[0] == player && board[3] == player && board[6] == player) true
        else if (board[1] == player && board[4] == player && board[7] == player) true
        else if (board[2] == player && board[5] == player && board[8] == player) true

        //check diagonals
        else if (board[2] == player && board[4] == player && board[6] == player) true
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


