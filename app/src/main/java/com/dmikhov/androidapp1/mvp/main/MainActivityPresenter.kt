package com.dmikhov.androidapp1.mvp.main

import com.dmikhov.androidapp1.entities.Delivery
import com.dmikhov.androidapp1.mvp.abs.BasePresenter
import com.dmikhov.androidapp1.domain.repository.RepositoryManager
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by dmikhov on 14.11.2016.
 */
class MainActivityPresenter: BasePresenter<MainActivity>() {

    override fun attachView(view: MainActivity) {
        super.attachView(view)
        fetchData()
    }

    val deliveriesObservable: Observable<List<Delivery>?>? = RepositoryManager.getDeliveries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .cache()

    private fun fetchData() {
        view?.onLoadingStarted()
        deliveriesObservable?.subscribe({ d ->
                    view?.onDataFetched(d)
                    view?.onLoadingFinished()
                }, { e ->
                    e.printStackTrace()
                    view?.onLoadingFinished()
                    view?.onError()
                })
    }
}
