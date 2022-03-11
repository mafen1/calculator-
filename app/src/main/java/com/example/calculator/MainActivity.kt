package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var ViewModel: ViewModel1
    private val TAG = "TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewModel = ViewModelProvider(this)[ViewModel1::class.java]
        initButton()
    }

    private fun initButton() {
        binding.button0.setOnClickListener {
            binding.textWorking.text = addNumber(0)

        }
        binding.button1.setOnClickListener {
            binding.textWorking.text = addNumber(1)
        }
        binding.button2.setOnClickListener {
            binding.textWorking.text = addNumber(2)
        }
        binding.button3.setOnClickListener {
            binding.textWorking.text = addNumber(3)
        }
        binding.button4.setOnClickListener {
            binding.textWorking.text = addNumber(4)
        }
        binding.button5.setOnClickListener {
            binding.textWorking.text = addNumber(5)
        }
        binding.button6.setOnClickListener {
            binding.textWorking.text = addNumber(6)
        }
        binding.button7.setOnClickListener {
            binding.textWorking.text = addNumber(7)
        }
        binding.button8.setOnClickListener {
            binding.textWorking.text = addNumber(8)
        }
        binding.button9.setOnClickListener {
            binding.textWorking.text = addNumber(9)
        }
        binding.buttonClearAll.setOnClickListener {
            binding.textWorking.text = ""
        }
        binding.buttonPlus.setOnClickListener {
            ViewModel.number1 = binding.textWorking.text.toString().toInt()
            binding.textWorking.text = ""
            ViewModel.currentButton = "plus"
        }
        binding.buttonMinus.setOnClickListener {
            ViewModel.number1 = binding.textWorking.text.toString().toInt()
            binding.textWorking.text = ""
            ViewModel.currentButton = "mines"
        }
        binding.buttonMultiplication.setOnClickListener {
            ViewModel.number1 = binding.textWorking.text.toString().toInt()
            binding.textWorking.text = ""
            ViewModel.currentButton = "multiplication"
        }
        binding.buttonDivision.setOnClickListener {
            ViewModel.number1 = binding.textWorking.text.toString().toInt()
            binding.textWorking.text = ""
            ViewModel.currentButton = "division"
        }
        binding.buttonPercent.setOnClickListener {
            ViewModel.number1 = binding.textWorking.text.toString().toInt()
            ViewModel.currentButton = "percent"
        }
        binding.buttonEquals.setOnClickListener {
            ViewModel.number2 = binding.textWorking.text.toString().toInt()
            binding.textResult.text = when (ViewModel.currentButton) {
                "mines" -> mines()
                "plus" -> plus()
                "plus" -> Log.d(TAG, "${plus()}")
                "multiplication" -> multiplation()
                "division" -> division()
                "percent" -> percent()
                else -> {
                    Log.d(TAG, "notWork")
                }
            }.toString()
        }

    }

    private fun addNumber(num: Int): String {
        return "${binding.textWorking.text}$num"
    }

    private fun plus(): Int {
        return ViewModel.number1 + ViewModel.number2
    }

    private fun mines(): Int {
        return ViewModel.number1 - ViewModel.number2
    }

    private fun multiplation(): Int {
        return ViewModel.number1 * ViewModel.number2
    }

    private fun division(): Int {
        return ViewModel.number1 / ViewModel.number2
    }

    private fun percent(): Int {
        return ViewModel.number1 / 100
    }
}