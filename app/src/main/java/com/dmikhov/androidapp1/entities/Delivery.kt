package com.dmikhov.androidapp1.entities

/**
 * Created by dmikhov on 14.11.2016.
 */
class Delivery(val id: Int, var name: String?, var orders: List<Order>?, var amountTotal: Int?) {
    override fun toString(): String {
        return "Delivery(id=$id, name=$name, orders=$orders, amountTotal=$amountTotal)"
    }
}
