package com.coulcod.grappstest.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coulcod.grappstest.R;
import com.coulcod.grappstest.presenter.ITrianglePreviewPresenter;
import com.coulcod.grappstest.presenter.TrianglePreviewPresenter;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class TrianglePreviewFragment extends Fragment implements ITrianglePreviewView {

    private ITrianglePreviewPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        presenter = new TrianglePreviewPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.triangle_preview_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.bindView(this);
    }

    @Override
    public void onDestroyView() {
        presenter.unBindView();
        super.onDestroyView();
    }

}
