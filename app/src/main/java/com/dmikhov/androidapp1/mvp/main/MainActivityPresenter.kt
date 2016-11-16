package com.dmikhov.androidapp1.mvp.main

import com.dmikhov.androidapp1.KotlinApp
import com.dmikhov.androidapp1.domain.repository.RepositoryManager
import com.dmikhov.androidapp1.entities.Delivery
import com.dmikhov.androidapp1.mvp.abs.BasePresenter
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by dmikhov on 14.11.2016.
 */
class MainActivityPresenter: BasePresenter<MainActivity>() {

    @Inject lateinit var repositoryManager: RepositoryManager

    init {
        KotlinApp.appComponent.inject(this)
    }

    override fun attachView(view: MainActivity) {
        super.attachView(view)
        fetchData()
    }

    val deliveriesObservable: Observable<List<Delivery>?>? = repositoryManager.getDeliveries()
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
