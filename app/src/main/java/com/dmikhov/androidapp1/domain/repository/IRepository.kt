package com.dmikhov.androidapp1.domain.repository

import com.dmikhov.androidapp1.entities.City
import com.dmikhov.androidapp1.entities.Delivery
import com.dmikhov.androidapp1.entities.Order
import rx.Observable

/**
 * Created by dmikhov on 14.11.2016.
 */
interface IRepository {
    fun getDeliveries(): Observable<List<Delivery>?>
    fun getCities(): Observable<List<City>?>
    fun getOrdersByDeliveryId(id: Int?) : Observable<List<Order>?>
}
