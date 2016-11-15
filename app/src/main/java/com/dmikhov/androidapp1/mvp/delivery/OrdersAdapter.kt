package com.dmikhov.androidapp1.mvp.delivery

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dmikhov.androidapp1.R
import com.dmikhov.androidapp1.entities.Order
import com.dmikhov.androidapp1.utils.Logger

/**
 * Created by dmikhov on 15.11.2016.
 */
class OrdersAdapter: RecyclerView.Adapter<OrdersAdapter.Holder>() {
    val logger: Logger = Logger(this.javaClass)
    var orders: List<Order>? = null

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        if(orders?.size ?: -1 > position) {
            var order: Order? = orders?.get(position)
            holder?.tvCityFrom?.text = order?.from?.name
            holder?.tvCityTo?.text = order?.to?.name
            holder?.tvAmount?.text = order?.amount?.toString()
        } else {
            logger.w("Some error in position: " + position)
        }
    }

    override fun getItemCount(): Int = orders?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent?.context).inflate(R.layout.item_order, parent, false))
    }

    class Holder: RecyclerView.ViewHolder{
        var tvCityFrom: TextView? = null
        var tvCityTo: TextView? = null
        var tvAmount: TextView? = null
        constructor(itemView: View?) : super(itemView) {
            tvCityFrom = itemView?.findViewById(R.id.tvCityFrom) as TextView
            tvCityTo = itemView?.findViewById(R.id.tvCityTo) as TextView
            tvAmount = itemView?.findViewById(R.id.tvAmount) as TextView
        }
    }

    fun updateData(orders: List<Order>?) {
        this.orders = orders
        notifyDataSetChanged()
    }
}
