package com.dmikhov.androidapp1.domain.repository

import com.dmikhov.androidapp1.domain.repository.abs.ICloudRepository
import com.dmikhov.androidapp1.domain.repository.abs.ILocalRepository
import com.dmikhov.androidapp1.domain.repository.abs.IRepository
import com.dmikhov.androidapp1.entities.City
import com.dmikhov.androidapp1.entities.Delivery
import com.dmikhov.androidapp1.entities.Order
import com.dmikhov.androidapp1.utils.Logger
import rx.Observable

/**
 * Created by dmikhov on 14.11.2016.
 */
class RepositoryManager constructor(val cloudRepository: ICloudRepository, val localRepository: ILocalRepository) : IRepository {
    private val logger = Logger(this.javaClass)
//    private val cloudRepository = CloudRepository()
//    private val localRepository = LocalRepository()


    override fun getDeliveries(): Observable<List<Delivery>?> {
        return localRepository.getDeliveries()
                .switchIfEmpty(cloudRepository.getDeliveries().doOnNext {
                    deliveries ->
                    localRepository.updateDeliveriesObservable(Observable.just(deliveries))
                })
    }

    override fun getCities(): Observable<List<City>?> = localRepository.getCities()
            .switchIfEmpty(cloudRepository.getCities().doOnNext {
                cities ->
                localRepository.updateCitiesObservable(Observable.just(cities))
            })

    override fun getOrdersByDeliveryId(id: Int?): Observable<List<Order>?> = localRepository.getOrdersByDeliveryId(id)
            .switchIfEmpty(cloudRepository.getOrdersByDeliveryId(id))
}

