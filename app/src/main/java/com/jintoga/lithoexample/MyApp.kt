package com.jintoga.lithoexample

import android.app.Application
import com.facebook.soloader.SoLoader

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
    }
}