package com.dmikhov.androidapp1.entities

/**
 * Created by dmikhov on 14.11.2016.
 */
class Order(var from: City, var to: City, var amount: Int) {
    override fun toString(): String {
        return "Order(from=$from, to=$to, amount=$amount)"
    }
}
