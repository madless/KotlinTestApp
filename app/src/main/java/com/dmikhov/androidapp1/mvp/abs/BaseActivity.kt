package com.dmikhov.androidapp1.mvp.abs

import android.support.v7.app.AppCompatActivity
import com.dmikhov.androidapp1.utils.Logger


/**
 * Created by dmikhov on 14.11.2016.
 */
open class BaseActivity : IView, AppCompatActivity() {
    protected val logger: Logger = Logger(this.javaClass)
}
