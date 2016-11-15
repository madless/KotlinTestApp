package com.dmikhov.androidapp1.entities

/**
 * Created by dmikhov on 14.11.2016.
 */
class City(var name:String, var population: Int, var location: Location) {
    override fun toString(): String {
        return "City(name='$name', population=$population, location=$location)"
    }
}
