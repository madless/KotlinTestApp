package com.dmikhov.androidapp1.domain.repository

import com.dmikhov.androidapp1.entities.City
import com.dmikhov.androidapp1.entities.Delivery
import com.dmikhov.androidapp1.entities.Order
import com.dmikhov.androidapp1.utils.Logger
import rx.Observable

/**
 * Created by dmikhov on 14.11.2016.
 */
object RepositoryManager: IRepository, CloudRepositoryUpdatedListener {
    private val logger = Logger(this.javaClass)
    private val cloudRepository = CloudRepository
    private val localRepository = LocalRepository

    override fun getDeliveries(): Observable<List<Delivery>?> {
        return localRepository.getDeliveries()
                .switchIfEmpty(cloudRepository.getDeliveries().doOnNext {
                    deliveries -> localRepository.deliveriesObservable =  Observable.just(deliveries)
                })
    }

    override fun getCities(): Observable<List<City>?> = localRepository.getCities()
            .switchIfEmpty(cloudRepository.getCities().doOnNext {
                cities -> localRepository.citiesObservable = Observable.just(cities)
            })

    override fun getOrdersByDeliveryId(id: Int?): Observable<List<Order>?> = localRepository.getOrdersByDeliveryId(id)
            .switchIfEmpty(cloudRepository.getOrdersByDeliveryId(id))

    override fun onDeliveriesUpdated(deliveriesObs: Observable<List<Delivery>?>) {

    }

    override fun onCitiesUpdated(citiesObs: Observable<List<City>?>) {

    }
}

