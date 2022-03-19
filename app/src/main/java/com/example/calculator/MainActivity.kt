package com.example.calculator

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.viewModel.ViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel: ViewModel by viewModels()
    companion object{
        lateinit var binding: ActivityMainBinding
        val TAG = "TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserves()

        binding.button0.setOnClickListener(this)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.buttonEquals.setOnClickListener(this)
        binding.buttonPlus.setOnClickListener(this)
        binding.buttonMinus.setOnClickListener(this)
        binding.buttonPercent.setOnClickListener(this)
        binding.buttonMultiplication.setOnClickListener(this)
        binding.buttonDivision.setOnClickListener(this)
        binding.buttonClearAll.setOnClickListener(this)

    }

    private fun updateText(text: String) {
        binding.EdTextWorking.setText("${binding.EdTextWorking.text}$text")
    }

    private fun initObserves() {
        viewModel.userInputFirstNumber.observe(this, androidx.lifecycle.Observer {
            updateText(it)
            Log.d(TAG, it)
        })

    }

    override fun onClick(view: View?) {

        // стало
        when (view!!.id) {
            R.id.button0 -> updateText("0")
            R.id.button1 -> updateText("1")
            R.id.button2 -> updateText("2")
            R.id.button3 -> updateText("3")
            R.id.button4 -> updateText("4")
            R.id.button5 -> updateText("5")
            R.id.button6 -> updateText("6")
            R.id.button7 -> updateText("7")
            R.id.button8 -> updateText("8")

            R.id.button9 -> updateText("9")
            R.id.buttonPlus ->{
                viewModel.choseOperations("+")
                viewModel.updateText("+")
            }
            R.id.buttonMinus -> {
                viewModel.choseOperations("-")
                viewModel.updateText("-")
            }
            R.id.buttonMultiplication -> {
                viewModel.choseOperations("*")
                viewModel.updateText("*")
            }
            R.id.buttonDivision -> {
                viewModel.choseOperations("/")
                viewModel.updateText("/")
            }
            R.id.buttonPercent -> {
                viewModel.choseOperations("%")
                viewModel.updateText("%")
            }
            R.id.buttonClearAll -> {
                viewModel.clearAll()
                binding.EdTextWorking.text = "".toString().toEditable()
            }
            R.id.buttonEquals -> {
                viewModel.operations(binding.EdTextWorking.text.toString())
                binding.textResult.text = viewModel.finalResult.toString()
            }
        }
    }
    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)
}