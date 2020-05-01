package com.isoft.rollthedice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var TAG:String = "MainActivity"
    var random_number: Int =0
    var playerAScore: Int = 0
    var playerBScore: Int = 0
    var activePlayer_A: Boolean = true
    var activePlayer_B: Boolean = false
    var gamePointValue: Int = 100
    var gameEndMsg: String? = null
    var gameEndMsgDefault: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //disable the dice image
        dice1_image.isEnabled = false

        btnStart.setOnClickListener {
            //enable the dice image
            dice1_image.isEnabled = true
            playerAScore = 0
            playerBScore = 0

            // clear the text views
            idWinnerMessage.text = ""
            lb_Player_A_Score.text = "0"
            lb_Player_B_Score.text = "0"

            //enable the player A
            activePlayer_A = true
            activePlayer_B = false

            // set the start image to 1
            dice1_image.setImageResource(R.drawable.die_face_1)

        }

        dice1_image.setOnClickListener {
            random_number = (1..6).random()

            when (random_number){
                1 -> {
                    dice1_image.setImageResource(R.drawable.die_face_1)
                }
                2 -> {
                    dice1_image.setImageResource(R.drawable.die_face_2)
                }
                3 -> {
                    dice1_image.setImageResource(R.drawable.die_face_3)
                }
                4 -> {
                    dice1_image.setImageResource(R.drawable.die_face_4)
                }
                5 -> {
                    dice1_image.setImageResource(R.drawable.die_face_5)
                }
                6 -> {
                    dice1_image.setImageResource(R.drawable.die_face_6)
                }
            }
            if (activePlayer_A){
                playerAScore += random_number
                lb_Player_A_Score.text = playerAScore.toString()
                activePlayer_A = false
                activePlayer_B = true

                if (playerAScore >= gamePointValue){
                    gameEndMsgDefault = resources.getText(R.string.game_over_message).toString()
                    gameEndMsg = gameEndMsgDefault + " Player A"
                    idWinnerMessage.text = gameEndMsg

                    dice1_image.isEnabled = false
                }
            }
            else{
                playerBScore += random_number
                lb_Player_B_Score.text = playerBScore.toString()
                activePlayer_B = false
                activePlayer_A = true

                if (playerBScore >= gamePointValue){
                    gameEndMsgDefault = resources.getText(R.string.game_over_message).toString()
                    gameEndMsg = gameEndMsgDefault + " Player B"
                    idWinnerMessage.text = gameEndMsg

                    dice1_image.isEnabled = false
                }
            }
        }
    }
}
