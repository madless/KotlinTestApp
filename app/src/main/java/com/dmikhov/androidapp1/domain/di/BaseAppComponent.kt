package com.dmikhov.androidapp1.domain.di

import com.dmikhov.androidapp1.mvp.delivery.DeliveryActivityPresenter
import com.dmikhov.androidapp1.mvp.main.MainActivityPresenter

/**
 * Created by dmikhov on 16.11.2016.
 */
interface BaseAppComponent {
    fun inject(mainActivityPresenter: MainActivityPresenter)
    fun inject(deliveryActivityPresenter: DeliveryActivityPresenter)
}
