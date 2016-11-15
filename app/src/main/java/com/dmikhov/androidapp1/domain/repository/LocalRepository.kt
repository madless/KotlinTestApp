package com.dmikhov.androidapp1.domain.repository

import com.dmikhov.androidapp1.entities.City
import com.dmikhov.androidapp1.entities.Delivery
import com.dmikhov.androidapp1.entities.Order
import com.dmikhov.androidapp1.utils.Logger
import rx.Observable

/**
 * Created by dmikhov on 14.11.2016.
 */
object LocalRepository: IRepository {
    private val logger = Logger(this.javaClass)
    var deliveriesObservable: Observable<List<Delivery>?> = Observable.empty()
    var citiesObservable: Observable<List<City>?> = Observable.empty()

    override fun getDeliveries(): Observable<List<Delivery>?> = deliveriesObservable

    override fun getCities(): Observable<List<City>?> = citiesObservable

    override fun getOrdersByDeliveryId(id: Int?): Observable<List<Order>?> {
        logger.d("orders loaded from local repository!")
        return deliveriesObservable
                .flatMapIterable { d -> d }
                .filter { d -> d.id == id }
                .single().map { d -> d.orders }
    }
}
