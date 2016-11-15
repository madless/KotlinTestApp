package com.dmikhov.androidapp1.domain.net

import com.dmikhov.androidapp1.entities.City
import com.dmikhov.androidapp1.entities.Delivery
import com.dmikhov.androidapp1.entities.Order
import rx.Observable

/**
 * Created by dmikhov on 14.11.2016.
 */
interface ServerApi {
    fun fetchDeliveries(): Observable<List<Delivery>?>
    fun fetchCities(): Observable<List<City>?>
    fun fetchOrdersByDeliveryId(id: Int?) : Observable<List<Order>?>
}
