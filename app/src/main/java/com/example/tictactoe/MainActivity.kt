package com.example.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<TicTacToeViewModel>()
    
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                Scaffold {
                    it.calculateBottomPadding()
                    // A surface container using the 'background' color from the theme
                    Surface {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Text("player ${mainViewModel.currentPlayer}\'s turn")
                            ButtonGrid(board = mainViewModel.board, mainViewModel::play)

                            if (mainViewModel.isGameOver) {
                                Box {
                                    Text(
                                        text = "Game is Over: ${mainViewModel.winner}",
                                        fontSize = 20.sp
                                    )
                                }
                            }

                            ResetButton(onClick = mainViewModel::reset)

                        }

                    }
                }
            }
        }
    }
}

@Composable
fun ButtonGrid(board: ArrayList<String>, onclick: (Int) -> Unit) {
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            TicTacToeButton(text = board[0]) { onclick(0) }
            TicTacToeButton(text = board[1]) { onclick(1) }
            TicTacToeButton(text = board[2]) { onclick(2) }
        }

        Row(horizontalArrangement = Arrangement.SpaceAround) {
            TicTacToeButton(text = board[3]) { onclick(3) }
            TicTacToeButton(text = board[4]) { onclick(4) }
            TicTacToeButton(text = board[5]) { onclick(5) }
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            TicTacToeButton(text = board[6]) { onclick(6) }
            TicTacToeButton(text = board[7]) { onclick(7) }
            TicTacToeButton(text = board[8]) { onclick(8) }
        }
    }
}


@Composable
fun TicTacToeButton(text: String, onclick: () -> Unit) {
    Box(modifier = Modifier.padding(8.dp)) {
        TextButton(
            shape = MaterialTheme.shapes.medium,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface),
            onClick = onclick,
            enabled = text.isBlank()
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Monospace
                ),
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(16.dp).size(40.dp).fillMaxHeight().align(Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun ResetButton(onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(16.dp).height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)) {
        Text(
            text = "Restart",
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.fillMaxWidth(),
            color = Color.White
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TicTacToeTheme {
        TicTacToeButton("x",{})
    }
}