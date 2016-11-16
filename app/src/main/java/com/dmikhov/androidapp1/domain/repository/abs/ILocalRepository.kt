package com.dmikhov.androidapp1.domain.repository.abs

import com.dmikhov.androidapp1.entities.City
import com.dmikhov.androidapp1.entities.Delivery
import rx.Observable

/**
 * Created by dmikhov on 16.11.2016.
 */
interface ILocalRepository: IRepository {
    fun updateDeliveriesObservable(deliveriesObs: Observable<List<Delivery>?>)
    fun updateCitiesObservable(citiesObs: Observable<List<City>?>)
}
