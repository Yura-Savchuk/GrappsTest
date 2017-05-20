package com.coulcod.grappstest.presenter;

import rx.Observable;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public interface IAreaUpdateTimer {

    Observable<?> updateAreaText();
    Observable<Long> updateTimerLeft();

}
