package com.dmikhov.androidapp1.domain.net

import com.dmikhov.androidapp1.entities.City
import com.dmikhov.androidapp1.entities.Delivery
import com.dmikhov.androidapp1.entities.Location
import com.dmikhov.androidapp1.entities.Order
import com.dmikhov.androidapp1.utils.Logger
import rx.Observable
import java.util.*

/**
 * Created by dmikhov on 16.11.2016.
 */
class MockServerApi: ServerApi {
    private val logger = Logger(javaClass)
    private var cities: List<City> = ArrayList()
    private var deliveries: List<Delivery>? = ArrayList()

    init {
        val odessa = City("Odessa", 940, Location(100, 150))
        val nikolaev = City("Nikolaev", 470, Location(120, 250))
        val voznesensk = City("Voznesensk", 43, Location(200, 350))
        val kiev = City("Kiev", 1635, Location(500, 650))
        val order1 = Order(odessa, nikolaev, 100)
        val order2 = Order(nikolaev, voznesensk, 40)
        val order3 = Order(voznesensk, odessa, 80)
        val order4 = Order(kiev, voznesensk, 10)
        val order5 = Order(kiev, odessa, 20)
        val order6 = Order(nikolaev, kiev, 10)
        val delivery1 = Delivery(0, "Test delivery", listOf(order1, order2, order3), 500)
        cities = listOf(odessa, nikolaev, voznesensk, kiev)
        deliveries = listOf(delivery1)
    }

    override fun fetchDeliveries() = Observable.create(Observable.OnSubscribe<List<Delivery>?>() { s ->
        run {
            logger.w("fetching deliveries from scratch...")
            Thread.sleep(2000)
            s.onNext(deliveries)
            s.onCompleted()
        }
    })

    override fun fetchCities() = Observable.create(Observable.OnSubscribe<List<City>?> { s ->
        run {
            logger.w("fetching cities from scratch...")
            Thread.sleep(2000)
            s.onNext(cities)
            s.onCompleted()
        }
    })

    override fun fetchOrdersByDeliveryId(id: Int?) = Observable.create(Observable.OnSubscribe<List<Order>> { s ->
        run {
            logger.w("fetching orders from scratch...")
            Thread.sleep(2000)
            s.onNext(deliveries?.filter { d -> d.id == id }?.single()?.orders)
            s.onCompleted()
        }
    })
}
