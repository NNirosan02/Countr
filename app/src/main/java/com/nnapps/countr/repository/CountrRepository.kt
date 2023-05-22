package com.nnapps.countr.repository

import com.nnapps.countr.CounterInterface
import javax.inject.Inject

class CountrRepository @Inject constructor(
    private val hitOrMissCounter: CounterInterface
) : CounterInterface {
    override fun getHitCount(): Int {
        return hitOrMissCounter.getHitCount()
    }

    override fun getTotalCount(): Int {
        return hitOrMissCounter.getTotalCount()
    }

    override fun incrementHitCount() {
        return hitOrMissCounter.incrementHitCount()
    }

    override fun incrementTotalCount() {
        return hitOrMissCounter.incrementTotalCount()
    }

    override fun resetCounts() {
        hitOrMissCounter.resetCounts()
    }
}
