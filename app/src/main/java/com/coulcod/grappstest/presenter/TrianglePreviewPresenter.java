package com.coulcod.grappstest.presenter;

import com.coulcod.grappstest.view.ITrianglePreviewView;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class TrianglePreviewPresenter implements ITrianglePreviewPresenter {

    private ITrianglePreviewView view;
    private CompositeSubscription compositeSubscr;
    private final IAreaUpdateTimer updateTimer;

    public TrianglePreviewPresenter() {
        updateTimer = new AreaUpdateTimer();
    }

    @Override
    public void bindView(ITrianglePreviewView view) {
        this.view = view;
        compositeSubscr = new CompositeSubscription();
    }

    @Override
    public void unBindView() {
        compositeSubscr.clear();
        view = null;
    }

    @Override
    public void setupUpdateArea() {
        Subscription subscription = updateTimer.updateAreaText()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> view.updateArea());
        compositeSubscr.add(subscription);
    }

    @Override
    public void setupUpdateTimer() {
        Subscription subscription = updateTimer.updateTimerLeft()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> view.setUpdateTimeLeft(aLong));
        compositeSubscr.add(subscription);
    }

}
