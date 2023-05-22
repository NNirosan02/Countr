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
        initTimber()
        initAdMob()
//        initFirebase()
    }

//    private fun initFirebase() {
//        analytics = Firebase.analytics
//    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initAdMob() {
        MobileAds.initialize(this)
    }
}
