package com.nnapps.countr

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class CountrApp : Application() {
    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate() {
        super.onCreate()
        initAdMob()
    }


    private fun initAdMob() {
        MobileAds.initialize(this)
    }
}
