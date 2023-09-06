package com.example.comparador

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    // Propiedades MutableLiveData para los textos y el resultado
    private val _firstText = MutableLiveData<String>()
    private val _secondText = MutableLiveData<String>()
    private val _comparisonResult = MutableLiveData<Boolean>()

    // LiveData para el view
    val firstText: LiveData<String> = _firstText
    val secondText: LiveData<String> = _secondText
    val comparisonResult: LiveData<Boolean> = _comparisonResult


    //commparando los textos
    fun compareTexts() {
        val first = _firstText.value.orEmpty()
        val second = _secondText.value.orEmpty()
        _comparisonResult.value = first == second
    }

    // actualizando  los textos desde la vista
    fun setFirstText(text: String) {
        _firstText.value = text
    }

    fun setSecondText(text: String) {
        _secondText.value = text
    }
}
