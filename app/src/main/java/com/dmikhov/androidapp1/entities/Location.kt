package com.dmikhov.androidapp1.entities

/**
 * Created by dmikhov on 14.11.2016.
 */
class Location(val lat: Int, val lon: Int){
    override fun toString(): String {
        return "Location(lat=$lat, lon=$lon)"
    }
}
