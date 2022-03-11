package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var number1 = 0
    private var number2 = 0
    private var currentButton = ""
    private val TAG = "TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
    }

    private fun initButton(){
        binding.button0.setOnClickListener {
            binding.textWorking.text = addNumber(binding.button0.text.toString())

        }
        binding.button1.setOnClickListener {
            binding.textWorking.text = addNumber(binding.button1.text.toString())
        }
        binding.button2.setOnClickListener {
            binding.textWorking.text = addNumber(binding.button2.text.toString())
        }
        binding.button3.setOnClickListener {
            binding.textWorking.text = addNumber(binding.button3.text.toString())
        }
        binding.button4.setOnClickListener {
            binding.textWorking.text = addNumber(binding.button4.text.toString())
        }
        binding.button5.setOnClickListener {
            binding.textWorking.text = addNumber(binding.button5.text.toString())
        }
        binding.button6.setOnClickListener {
            binding.textWorking.text = addNumber(binding.button6.text.toString())
        }
        binding.button7.setOnClickListener {
            binding.textWorking.text = addNumber(binding.button7.text.toString())
        }
        binding.button8.setOnClickListener {
            binding.textWorking.text = addNumber(binding.button8.text.toString())
        }
        binding.button9.setOnClickListener {
            binding.textWorking.text = addNumber(binding.button9.text.toString())
        }
        binding.buttonClearAll.setOnClickListener {
           binding.textWorking.text = ""
        }
        binding.buttonPlus.setOnClickListener {
            number1 = binding.textWorking.text.toString().toInt()
            binding.textWorking.text = ""
            currentButton = "plus"
        }
        binding.buttonMinus.setOnClickListener{
            number1 = binding.textWorking.text.toString().toInt()
            binding.textWorking.text = ""
            currentButton = "mines"
        }
        binding.buttonMultiplication.setOnClickListener {
            number1 = binding.textWorking.text.toString().toInt()
            binding.textWorking.text = ""
            currentButton = "multiplication"
        }
        binding.buttonDivision.setOnClickListener {
            number1 = binding.textWorking.text.toString().toInt()
            binding.textWorking.text = ""
            currentButton = "division"
        }
        binding.buttonPercent.setOnClickListener {
            number1 = binding.textWorking.text.toString().toInt()
            currentButton = "percent"
        }
        binding.buttonEquals.setOnClickListener {
            number2 = binding.textWorking.text.toString().toInt()
            binding.textResult.text = when(currentButton){
                "mines" -> mines()
                "plus" -> plus()
                "multiplication" ->  multiplation()
                "division" ->  division()
                "percent" -> percent()
                else -> {
                    Log.d(TAG, "notWork")
                }
            }.toString()
        }

    }
    private fun addNumber(button: String): String{
        return "${binding.textWorking.text}$button"
    }
    private fun plus() :Int{
        return number1 + number2
    }
    private fun mines() :Int{
        return number1 - number2
    }
    private fun multiplation() :Int{
        return number1 * number2
    }
    private fun division():Int{
        return number1 / number2
    }
    private fun percent(): Int{
        return number1 / 100
    }
}