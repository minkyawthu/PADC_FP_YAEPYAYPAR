package com.padc.yaepyaypar.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.yaepyaypar.R;

import java.util.List;


/**
 * A simple adapter to display a options of a quiz.
 */
public class OptionsQuizAdapter extends BaseAdapter {

    private final List<String> mOptions;
    private final int mLayoutId;
    private final String[] mAlphabet;

    /**
     * Creates an {@link OptionsQuizAdapter}.
     *  @param options The options to add to the adapter.
     * @param layoutId Must consist of a single {@link TextView}.
     */
    public OptionsQuizAdapter(List<String> options, @LayoutRes int layoutId) {
        mOptions = options;
        mLayoutId = layoutId;
        mAlphabet = null;
    }



    @Override
    public int getCount() {
        return mOptions.size();
    }

    @Override
    public String getItem(int position) {
        return mOptions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        /* Important to return tru ein order to get checked items from this adapter correctly */
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(mLayoutId, parent, false);
        }
       TextView txtview = (TextView) convertView.findViewById(R.id.txt_answer);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_answer);
        txtview.setText(mOptions.get(position));

        return convertView;
    }

    private String getText(int position) {
        String text;
        if (mAlphabet == null) {
            text = getItem(position);
        } else {
            text = getPrefix(position) + getItem(position);
        }
        return text;
    }

    private String getPrefix(int position) {
        final int length = mAlphabet.length;
        if (position >= length || 0 > position) {
            throw new IllegalArgumentException(
                    "Only positions between 0 and " + length + " are supported");
        }
        StringBuilder prefix;
        if (position < length) {
            prefix = new StringBuilder(mAlphabet[position]);
        } else {
            int tmpPosition = position % length;
            prefix = new StringBuilder(tmpPosition);
            prefix.append(getPrefix(position - tmpPosition));
        }
        prefix.append(". ");
        return prefix.toString();
    }
}
