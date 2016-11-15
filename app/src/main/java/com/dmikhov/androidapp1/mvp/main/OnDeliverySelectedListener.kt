package com.dmikhov.androidapp1.mvp.main

import com.dmikhov.androidapp1.entities.Delivery

/**
 * Created by dmikhov on 15.11.2016.
 */
interface OnDeliverySelectedListener {
    fun onDeliverySelected(delivery: Delivery)
}
