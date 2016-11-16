package com.dmikhov.androidapp1.domain.repository

import com.dmikhov.androidapp1.domain.net.ServerDataLoader
import com.dmikhov.androidapp1.domain.repository.abs.ICloudRepository

/**
 * Created by dmikhov on 14.11.2016.
 */
class CloudRepository constructor() : ICloudRepository {

    val api = ServerDataLoader

    override fun getDeliveries() = api.fetchDeliveries()

    override fun getCities() = api.fetchCities()

    override fun getOrdersByDeliveryId(id: Int?) = api.fetchOrdersByDeliveryId(id)
}
