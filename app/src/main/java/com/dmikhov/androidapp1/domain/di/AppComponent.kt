package com.dmikhov.androidapp1.domain.di

import com.dmikhov.androidapp1.mvp.delivery.DeliveryActivityPresenter
import com.dmikhov.androidapp1.mvp.main.MainActivityPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dmikhov on 15.11.2016.
 */
@Component(modules = arrayOf(ManagerModule::class, RepositoryModule::class))
@Singleton
interface AppComponent {
    fun inject(mainActivityPresenter: MainActivityPresenter)
    fun inject(deliveryActivityPresenter: DeliveryActivityPresenter)
}
