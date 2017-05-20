package com.coulcod.grappstest.presenter;

import com.coulcod.grappstest.view.ITrianglePreviewView;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public interface ITrianglePreviewPresenter {

    void bindView(ITrianglePreviewView view);
    void unBindView();

    void setupUpdateArea();
    void setupUpdateTimer();

}
