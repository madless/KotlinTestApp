package com.dmikhov.androidapp1.mvp.abs

import com.dmikhov.androidapp1.utils.Logger

/**
 * Created by dmikhov on 14.11.2016.
 */
abstract class BasePresenter<V : IView> {
    protected val logger: Logger = Logger(this.javaClass)
    var view: V? = null

    open fun attachView(view: V) {
        this.view = view
    }

    open fun onDestroy() {}
}
