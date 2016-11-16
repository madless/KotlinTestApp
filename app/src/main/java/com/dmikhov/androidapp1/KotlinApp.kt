package com.dmikhov.androidapp1

import android.app.Application
import com.dmikhov.androidapp1.domain.di.BaseAppComponent
import com.dmikhov.androidapp1.domain.di.DaggerAppComponent

/**
 * Created by dmikhov on 15.11.2016.
 */
class KotlinApp: Application() {

    companion object {
        lateinit var appComponent: BaseAppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
//        appComponent = DaggerTestAppComponent.builder().build()
    }
}