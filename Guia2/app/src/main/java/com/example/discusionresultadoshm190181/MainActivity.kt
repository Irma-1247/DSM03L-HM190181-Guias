package com.example.discusionresultadoshm190181

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num1=findViewById<EditText>(R.id.txtFirstNumber)
        val num2=findViewById<EditText>(R.id.txtSecondNumber)
        val result=findViewById<TextView>(R.id.txtResultado)
        val button=findViewById<Button>(R.id.btnSumar)

        button.setOnClickListener{
            val nr1 = num1.text.toString().toInt()
            val nr2 = num2.text.toString().toInt()
            val suma = nr1 + nr2
            result.text = "Resultado: ${suma.toString()}"
        }
    }
}