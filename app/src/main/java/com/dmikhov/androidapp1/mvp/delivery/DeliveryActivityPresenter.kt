package com.dmikhov.androidapp1.mvp.delivery

import com.dmikhov.androidapp1.KotlinApp
import com.dmikhov.androidapp1.domain.repository.RepositoryManager
import com.dmikhov.androidapp1.entities.Order
import com.dmikhov.androidapp1.mvp.abs.BasePresenter
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by dmikhov on 15.11.2016.
 */
open class DeliveryActivityPresenter(deliveryId: Int?) : BasePresenter<DeliveryActivity>() {
    var deliveryId: Int? = null
    @Inject lateinit var repositoryManager: RepositoryManager

    init {
        KotlinApp.appComponent.inject(this)
    }


    override fun attachView(view: DeliveryActivity) {
        super.attachView(view)
        fetchData()
    }

    val ordersObservable: Observable<List<Order>?>? = repositoryManager.getOrdersByDeliveryId(deliveryId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .cache()

    private fun fetchData() {
        view?.onLoadingStarted()
        ordersObservable?.subscribe({ orders ->
                    view?.onDataFetched(orders)
                    view?.onLoadingFinished()
                }, { e ->
                    e.printStackTrace()
                    view?.onLoadingFinished()
                    view?.onError()
                })
    }

}
