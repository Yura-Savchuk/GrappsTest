package com.coulcod.grappstest.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coulcod.grappstest.R;
import com.coulcod.grappstest.presenter.ITrianglePreviewPresenter;
import com.coulcod.grappstest.presenter.TrianglePreviewPresenter;
import com.coulcod.triangleview.TriangleArea;
import com.coulcod.triangleview.TriangleView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class TrianglePreviewFragment extends Fragment implements ITrianglePreviewView {

    @BindView(R.id.triangleView) TriangleView triangleView;
    @BindView(R.id.triangleAreaTv) TextView triangleAreaTv;
    @BindView(R.id.triangleUpdateTimerTv) TextView triangleUpdateTimerTv;

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
        ButterKnife.bind(this, view);
        presenter.bindView(this);
        presenter.setupUpdateArea();
        presenter.setupUpdateTimer();
    }

    @Override
    public void onDestroyView() {
        presenter.unBindView();
        super.onDestroyView();
    }

    @Override
    public void updateArea() {
        TriangleArea area = triangleView.getArea();
        String text = getString(R.string.last_triangle_area_d_px, area.getValue());
        triangleAreaTv.setText(text);
    }

    @Override
    public void setUpdateTimeLeft(long seconds) {
        String text = getString(R.string.next_area_update_in_d, seconds);
        triangleUpdateTimerTv.setText(text);
    }

}
