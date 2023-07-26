package com.nnapps.countr

import android.app.Application
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CountrApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initAdMob()
    }


    private fun initAdMob() {
        MobileAds.initialize(this)
    }
}
