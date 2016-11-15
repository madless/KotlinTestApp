package com.dmikhov.androidapp1.mvp.cache

import android.support.v4.util.SimpleArrayMap
import com.dmikhov.androidapp1.mvp.abs.BasePresenter

/**
 * Created by dmikhov on 14.11.2016.
 */
object PresenterCache {

    private val presenters: SimpleArrayMap<String, BasePresenter<*>> = SimpleArrayMap()

    @Suppress("UNCHECKED_CAST")
    fun <T : BasePresenter<*>> getPresenter(tag: String, presentersFactory: PresenterFactory<T>): T? {
        var presenter: T? = null
        try {
            presenter = presenters.get(tag) as T
        } catch (e: ClassCastException) {}

        if (presenter == null) {
            presenter = presentersFactory.createPresenter()
            presenters.put(tag, presenter)
        }

        return presenter
    }

    fun removePresenter(tag: String) {
        presenters.remove(tag)
    }
}
