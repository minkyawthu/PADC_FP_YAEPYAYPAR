package com.padc.yaepyaypar.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.Utils.OffsetDecoration;
import com.padc.yaepyaypar.adapters.YayPayparCategoryAdapter;
import com.padc.yaepyaypar.model.YaypayparModel;
import com.padc.yaepyaypar.views.listitemClicklistner;
import com.padc.yaepyaypar.vos.YayPayParVo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kaungkhantthu on 9/11/16.
 */
public class YaypayparFragment extends Fragment implements listitemClicklistner {

    @BindView(R.id.categories)
    RecyclerView categoriesView;

    private YayPayparCategoryAdapter yaypar;
    private YayPayparCategoryAdapter mAdapter;
    private ArrayList<YayPayParVo> yaypayparlist;


    public YaypayparFragment() {
    }

    public static Fragment newInstance() {
        Fragment fragment = new YaypayparFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        YaypayparModel.getInstance().loadAttractions();
        View v;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_yaypaypar, container, false);
        ButterKnife.bind(this, rootView);
       yaypayparlist = (ArrayList<YayPayParVo>) YaypayparModel.getInstance().getAttractionList();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        final int spacing = getContext().getResources()
                .getDimensionPixelSize(R.dimen.spacing_nano);
        categoriesView.addItemDecoration(new OffsetDecoration(spacing));
        mAdapter = new YayPayparCategoryAdapter(getActivity(),this,yaypayparlist);

        categoriesView.setAdapter(mAdapter);
        categoriesView.getViewTreeObserver()
                .addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        categoriesView.getViewTreeObserver().removeOnPreDrawListener(this);
                        getActivity().supportStartPostponedEnterTransition();
                        return true;
                    }
                });
    }

    @Override
    public void onClick(int position) {

    }
}

