package com.dmikhov.androidapp1.domain.repository

import com.dmikhov.androidapp1.entities.City
import com.dmikhov.androidapp1.entities.Delivery
import rx.Observable

/**
 * Created by dmikhov on 15.11.2016.
 */
interface CloudRepositoryUpdatedListener {
    fun onDeliveriesUpdated(deliveriesObs: Observable<List<Delivery>?>)
    fun onCitiesUpdated(citiesObs: Observable<List<City>?>)
}
