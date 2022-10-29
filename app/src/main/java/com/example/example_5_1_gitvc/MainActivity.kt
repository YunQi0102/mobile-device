package com.example.example_5_1_gitvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //綁定變數與畫面元件
        val tvRiddle = findViewById<TextView>(R.id.tv_riddle)
        val edAnswer = findViewById<EditText>(R.id.ed_answer)
        val btnRiddle = findViewById<Button>(R.id.btn_riddle)
        val btnAnswer = findViewById<Button>(R.id.btn_answer)
        val btnReAnswer = findViewById<Button>(R.id.btn_reAnswer)
        val btnShowAnswer = findViewById<Button>(R.id.btn_showAnswer)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        //用list儲存謎題及答案
        var index = 0
        val riddleList = mutableListOf("採購象棋。猜一成語。:招兵買馬","1+2+3。猜一成語。:接二連三","哥哥怕弟弟。猜一成語。:後生可畏","0000。猜一成語。:四大皆空")
        //出題鍵
        edAnswer.text = null
        tvResult.text = null
        btnRiddle.setOnClickListener {
            edAnswer.text = null
            tvResult.text = null
            index = (Math.random()*4).toInt()
            val (riddle,answer) = riddleList[index].split(":")
            tvRiddle.text = "謎題：" + riddle
        }
        //答題鍵
        btnAnswer.setOnClickListener {
            val (riddle,answer) = riddleList[index].split(":")
            val ans = edAnswer.text
            if (ans.toString()==answer) {
                tvResult.text = "您答對了！"
//                Toast.makeText(this,edAnswer.text,Toast.LENGTH_SHORT).show()
            }
            else {
                tvResult.text ="您答錯了，請再試一次。"
            }
        }
        //重答鍵
        btnReAnswer.setOnClickListener {
            edAnswer.text = null
            tvResult.text = null
        }
        //看謎底鍵
        btnShowAnswer.setOnClickListener {
            val (riddle,answer) = riddleList[index].split(":")
            tvResult.text = "謎底是：" + answer
        }
    }
}