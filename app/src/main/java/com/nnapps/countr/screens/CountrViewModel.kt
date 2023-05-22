package com.nnapps.countr.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nnapps.countr.repository.CountrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountrViewModel @Inject constructor(
    private val repository: CountrRepository
) : ViewModel() {

    private val _hitCount = MutableLiveData<Int>()
    val hitCount: LiveData<Int> = _hitCount

    private val _totalCount = MutableLiveData<Int>()
    val totalCount: LiveData<Int> = _totalCount

    init {
        updateValues()
    }

    fun onHitButtonClicked() {
        repository.incrementHitCount()
        updateValues()
    }

    fun onMissButtonClicked() {
        repository.incrementTotalCount()
        updateValues()
    }

    fun onResetButtonClicked() {
        repository.resetCounts()
        updateValues()
    }

    private fun updateValues() {
        updateHitCountValue()
        updateTotalCountValue()
    }

    private fun updateTotalCountValue() {
        _totalCount.value = repository.getTotalCount()
    }

    private fun updateHitCountValue() {
        _hitCount.value = repository.getHitCount()
    }
}
