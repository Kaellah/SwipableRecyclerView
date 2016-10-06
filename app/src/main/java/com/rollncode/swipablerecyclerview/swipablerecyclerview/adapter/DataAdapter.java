package com.rollncode.swipablerecyclerview.swipablerecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rollncode.swipablerecyclerview.swipablerecyclerview.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Chekashov R.(email:roman_woland@mail.ru)
 * @since 04.10.16
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private final static String[] values = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    private ArrayList<String> mDataSet;

    public DataAdapter() {
        mDataSet = new ArrayList<>(Arrays.asList(values));
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mTextView.setText(mDataSet.get(i));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        View mView;

        public ViewHolder(View view) {
            super(view);

            mView = view;
            mTextView = (TextView) view.findViewById(R.id.textView);
        }

        public View getView() {
            return mView;
        }
    }

    public ArrayList<String> getData() {
        return mDataSet;
    }

    public void remove(int position) {
        mDataSet.remove(position);
        notifyItemRemoved(position);
    }
}
