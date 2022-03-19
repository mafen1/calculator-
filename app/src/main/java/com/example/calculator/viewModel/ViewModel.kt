package com.example.calculator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {


    var finalResult: Int = 0
    var operationInViewModel = ""

    private val _userInputFirstNumber: MutableLiveData<String> = MutableLiveData("")
    val userInputFirstNumber: LiveData<String> = _userInputFirstNumber

    private val _oprerations: MutableLiveData<String> = MutableLiveData("")

    private var _result: MutableLiveData<String> = MutableLiveData("")

    fun updateText(string: String) {
        _userInputFirstNumber.postValue(string)
    }
    fun choseOperations(operation: String): String{
        _oprerations.value = operation
        operationInViewModel = operation
        return _oprerations.value.toString()
    }
    fun operations(result: String) {
        _result.value = result
        val getString = _result.value!!.split(operationInViewModel)
        when(_oprerations.value){
            "+" -> finalResult = getString[0].toInt() + getString[1].toInt()
            "-" -> finalResult = getString[0].toInt() - getString[1].toInt()
            "*" -> finalResult = getString[0].toInt() * getString[1].toInt()
            "/" -> finalResult = getString[0].toInt() / getString[1].toInt()
            "%" -> finalResult = getString[0].toInt() / 100
        }
    }
    fun clearAll(){
        _userInputFirstNumber.postValue("")
        _oprerations.postValue("")
        _result.postValue("")
    }
}