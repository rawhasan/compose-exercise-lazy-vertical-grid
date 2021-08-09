package com.example.lazyverticalgrid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DestinationViewModel : ViewModel() {
//    var title = mutableStateOf("Lazy Vertical Grid")
//        private set

    private var _title = MutableLiveData("")
    val title: LiveData<String>
        get() = _title

    fun setTitle(newTitle: String) {
        _title.value = newTitle
        Log.d("ViewModel_title", _title.value.toString())
        Log.d("ViewModelTitle", title.value.toString())
    }
}