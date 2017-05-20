package com.coulcod.grappstest.presenter;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

class AreaUpdateTimer implements IAreaUpdateTimer {

    private static final long UPDATE_INTERVAL_SECONDS = 5;

    private long secondsLeft = UPDATE_INTERVAL_SECONDS;

    @Override
    public Observable<?> updateAreaText() {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .filter(left -> {
                    secondsLeft--;
                    return secondsLeft <= 0;
                })
                .doOnNext(left -> secondsLeft = UPDATE_INTERVAL_SECONDS);
    }

    @Override
    public Observable<Long> updateTimerLeft() {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .map(aLong -> secondsLeft);
    }

}
