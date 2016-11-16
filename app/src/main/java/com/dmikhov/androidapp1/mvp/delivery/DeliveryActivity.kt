package com.dmikhov.androidapp1.mvp.delivery

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.dmikhov.androidapp1.R
import com.dmikhov.androidapp1.entities.Order
import com.dmikhov.androidapp1.mvp.abs.BaseActivity
import com.dmikhov.androidapp1.mvp.cache.PresenterCache
import com.dmikhov.androidapp1.mvp.cache.PresenterFactory
import com.dmikhov.androidapp1.utils.Const

/**
 * Created by dmikhov on 15.11.2016.
 */
class DeliveryActivity: BaseActivity<DeliveryActivityPresenter>() {

    var adapter: OrdersAdapter? = null
    var rvOrders: RecyclerView? = null
    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery)
        rvOrders = findViewById(R.id.rvOrders) as RecyclerView
        progressBar = findViewById(R.id.progressBar) as ProgressBar
        rvOrders?.layoutManager = LinearLayoutManager(this)
        adapter = OrdersAdapter()
        rvOrders?.adapter = adapter
        val id = intent.getIntExtra(Const.EXTRA_SELECT_DELIVERY_ID, -1)
        logger.d("opened delivery: " + id)
        val factory = PresenterFactory() { DeliveryActivityPresenter(id) }
        presenter = PresenterCache.getPresenter(Const.PRESENTER_CACHE_DELIVERY_ACTIVITY, factory)
        presenter?.attachView(this)
    }

    fun onDataFetched(orders: List<Order>?) {
        logger.d("on data fetched: $orders")
        adapter?.updateData(orders)
    }

    fun onLoadingStarted() {
        progressBar?.visibility = View.VISIBLE
    }

    fun onLoadingFinished() {
        progressBar?.visibility = View.GONE
    }

    fun onError() {
        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        if(!isChangingConfigurations && isFinishing) {
            presenter?.onDestroy()
            PresenterCache.removePresenter(Const.PRESENTER_CACHE_DELIVERY_ACTIVITY)
        }
    }
}
