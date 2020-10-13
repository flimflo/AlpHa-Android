package com.flimflo.alpha.ui.sponsors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SponsorsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is sponsors Fragment"
    }
    val text: LiveData<String> = _text
}