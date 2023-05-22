package com.nnapps.countr

import android.content.SharedPreferences

interface CounterInterface {
    fun getHitCount(): Int
    fun getTotalCount(): Int
    fun incrementHitCount()
    fun incrementTotalCount()
    fun resetCounts()
}

class SharedPrefsHitOrMissCounter(private val sharedPreferences: SharedPreferences) :
    CounterInterface {
    private companion object {
        const val KEY_HIT_COUNT = "hit_count"
        const val KEY_TOTAL_COUNT = "total_count"
    }

    override fun getHitCount(): Int {
        return sharedPreferences.getInt(KEY_HIT_COUNT, 0)
    }

    override fun getTotalCount(): Int {
        return sharedPreferences.getInt(KEY_TOTAL_COUNT, 0)
    }

    override fun incrementHitCount() {
        val currentCount = getHitCount()
        sharedPreferences.edit().putInt(KEY_HIT_COUNT, currentCount + 1).apply()
        incrementTotalCount()
    }

    override fun incrementTotalCount() {
        val currentCount = getTotalCount()
        sharedPreferences.edit().putInt(KEY_TOTAL_COUNT, currentCount + 1).apply()
    }

    override fun resetCounts() {
        sharedPreferences.edit().remove(KEY_HIT_COUNT).remove(KEY_TOTAL_COUNT).apply()
    }
}
