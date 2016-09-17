package com.padc.yaepyaypar.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.YaePyayParApp;
import com.padc.yaepyaypar.views.items.ViewItemCountry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkt on 9/17/2016.
 */
public class CountryListAdapter extends BaseAdapter {

    private List<String> mCountryList;
    private LayoutInflater mInflater;

    public CountryListAdapter(List<String> countryList) {
        if (countryList != null) {
            this.mCountryList = countryList;
        } else {
            this.mCountryList = new ArrayList<>();
        }
        mInflater = LayoutInflater.from(YaePyayParApp.getContext());
    }

    @Override
    public int getCount() {
        return mCountryList.size();
    }

    @Override
    public String getItem(int position) {
        return mCountryList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.view_item_country, parent, false);
        }

        if (convertView instanceof ViewItemCountry) {
            ViewItemCountry viCountry = (ViewItemCountry) convertView;
            viCountry.setData(getItem(position));
        }

        return convertView;
    }
}