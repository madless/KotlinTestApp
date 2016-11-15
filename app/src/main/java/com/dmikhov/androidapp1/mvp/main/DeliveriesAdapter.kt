package com.dmikhov.androidapp1.mvp.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dmikhov.androidapp1.R
import com.dmikhov.androidapp1.entities.Delivery
import com.dmikhov.androidapp1.utils.Logger

/**
 * Created by dmikhov on 14.11.2016.
 */
class DeliveriesAdapter: RecyclerView.Adapter<DeliveriesAdapter.Holder>() {
    val logger: Logger = Logger(this.javaClass)
    var deliveries: List<Delivery>? = null
    var onDeliverySelectedListener: OnDeliverySelectedListener? = null

    override fun getItemCount(): Int {
        return deliveries?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_delivery, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        if(deliveries?.size ?: -1 > position) {
            var delivery: Delivery? = deliveries?.get(position)
            holder?.tvDeliveryName?.text = delivery?.name
            holder?.root?.tag = delivery
            holder?.root?.setOnClickListener {
                v -> onDeliverySelectedListener?.onDeliverySelected(v.tag as Delivery)
            }
        } else {
            logger.w("Some error in position: " + position)
        }
    }

    class Holder: RecyclerView.ViewHolder {
        var tvDeliveryName: TextView? = null
        var root: View? = null
        constructor(view: View) : super(view) {
            root = view
            tvDeliveryName = view.findViewById(R.id.tvDeliveryName) as TextView
        }
    }

    fun updateDeliveries(deliveries: List<Delivery>?) {
        this.deliveries = deliveries
        notifyDataSetChanged()
    }
}
