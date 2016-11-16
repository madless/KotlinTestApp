package com.dmikhov.androidapp1

import android.app.Application
import com.dmikhov.androidapp1.domain.di.AppComponent
import com.dmikhov.androidapp1.domain.di.DaggerAppComponent

/**
 * Created by dmikhov on 15.11.2016.
 */
class KotlinApp: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}