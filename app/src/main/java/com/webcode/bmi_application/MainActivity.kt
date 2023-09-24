package com.webcode.bmi_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var weightTXT :EditText
    private lateinit var heightTXT :EditText
    private lateinit var CalBTn :Button
    private lateinit var ResultShow :TextView


    private fun validateInput(weight: String, height: String): Boolean {
        return when {
            weight.isNullOrEmpty() ->{
                Toast.makeText(this,"Weight is Empty", Toast.LENGTH_SHORT).show()
                return false
            }

            height.isNullOrEmpty() -> {
             Toast.makeText(this,"Height is Empty", Toast.LENGTH_SHORT).show()
             return false

            }

            else -> {
                return true
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        weightTXT = findViewById(R.id.WEIGHTEDTXT)
        heightTXT = findViewById(R.id.HEIGHTEDTXT)
        CalBTn = findViewById(R.id.CalBtn)
        ResultShow = findViewById(R.id.ReusltShowTXt)

        CalBTn.setOnClickListener {
            val Weight = weightTXT.text.toString()
            val Height = heightTXT.text.toString()

            if(validateInput(Weight, Height)){
                val bmi = Weight.toDouble()/((Height.toDouble()/100)*((Height.toDouble()/100)))

                val BMIDigit = String.format("%.2f", bmi).toFloat()

                DisplayResult(BMIDigit)
            }
        }
    }

    private fun DisplayResult(bmiDigit: Float) {
        ResultShow.text = bmiDigit.toString()

    }
}
