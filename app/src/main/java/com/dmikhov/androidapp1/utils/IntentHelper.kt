package com.dmikhov.androidapp1.utils

import android.app.Activity
import android.content.Intent
import com.dmikhov.androidapp1.mvp.delivery.DeliveryActivity

/**
 * Created by dmikhov on 15.11.2016.
 */
object IntentHelper {

    val logger = Logger(IntentHelper.javaClass)

    fun openDeliveryActivity(activity: Activity, deliveryId: Int) {
        val intent = Intent(activity, DeliveryActivity::class.java)
        intent.putExtra(Const.EXTRA_SELECT_DELIVERY_ID, deliveryId)
        activity.startActivity(intent)
    }
}
