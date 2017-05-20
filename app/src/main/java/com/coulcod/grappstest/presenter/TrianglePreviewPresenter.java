package com.coulcod.grappstest.presenter;

import com.coulcod.grappstest.view.ITrianglePreviewView;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class TrianglePreviewPresenter implements ITrianglePreviewPresenter {

    private ITrianglePreviewView view;

    @Override
    public void bindView(ITrianglePreviewView view) {
        this.view = view;
    }

    @Override
    public void unBindView() {
        view = null;
    }
}
