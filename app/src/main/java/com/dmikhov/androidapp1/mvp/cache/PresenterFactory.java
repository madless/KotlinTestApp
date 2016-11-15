package com.dmikhov.androidapp1.mvp.cache;

import com.dmikhov.androidapp1.mvp.abs.BasePresenter;

/**
 * Created by dmikhov on 14.11.2016.
 */
public interface PresenterFactory<T extends BasePresenter> {
    T createPresenter();
}
