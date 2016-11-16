package com.dmikhov.androidapp1.mvp.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.dmikhov.androidapp1.R
import com.dmikhov.androidapp1.entities.Delivery
import com.dmikhov.androidapp1.mvp.abs.BaseActivity
import com.dmikhov.androidapp1.mvp.cache.PresenterCache
import com.dmikhov.androidapp1.mvp.cache.PresenterFactory
import com.dmikhov.androidapp1.utils.Const
import com.dmikhov.androidapp1.utils.IntentHelper

class MainActivity : BaseActivity<MainActivityPresenter>(), OnDeliverySelectedListener {

    var rvDeliveries: RecyclerView? = null
    var progressBar: ProgressBar? = null
    var adapter: DeliveriesAdapter? = null
    val factory = PresenterFactory() { MainActivityPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvDeliveries = findViewById(R.id.recyclerView) as RecyclerView
        progressBar = findViewById(R.id.progressBar) as ProgressBar
        rvDeliveries?.layoutManager = LinearLayoutManager(this)
        adapter = DeliveriesAdapter()
        adapter?.onDeliverySelectedListener = this
        rvDeliveries?.adapter = adapter
        presenter = PresenterCache.getPresenter(Const.PRESENTER_CACHE_MAIN_ACTIVITY, factory)
        presenter?.attachView(this)
    }

    public fun onDataFetched(deliveries: List<Delivery>?) {
        adapter?.updateDeliveries(deliveries)
    }

    fun onError() {
        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
    }

    fun onLoadingStarted() {
        progressBar?.visibility = View.VISIBLE
    }

    fun onLoadingFinished() {
        progressBar?.visibility = View.GONE
    }

    override fun onDeliverySelected(delivery: Delivery) {
        IntentHelper.openDeliveryActivity(this, delivery.id)
    }

    override fun onStop() {
        super.onStop()
        if(!isChangingConfigurations && isFinishing) {
            presenter?.onDestroy()
            PresenterCache.removePresenter(Const.PRESENTER_CACHE_MAIN_ACTIVITY)
        }
    }
}
