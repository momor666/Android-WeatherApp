package com.sbhachu.weather.presentation.common.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import com.sbhachu.weather.presentation.common.view.BaseRecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T, V extends View> extends RecyclerView.Adapter<BaseRecyclerView<V>> {

    public interface OnRecyclerItemClickListener<T> {
        void onRecyclerItemClicked(View view, T item);
    }

    public interface OnRecyclerItemContextButtonClickListener<T> {
        void onRecyclerItemContextButtonClicked(View view, T item);
    }

    private OnRecyclerItemClickListener<T> itemClickListener;
    private OnRecyclerItemContextButtonClickListener itemContextButtonClickListener;

    private List<T> items = new ArrayList<>();

    @Override
    public BaseRecyclerView<V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRecyclerView<>(onCreateItemView(parent, viewType));
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public OnRecyclerItemClickListener<T> getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(OnRecyclerItemClickListener<T> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public OnRecyclerItemContextButtonClickListener getItemContextButtonClickListener() {
        return itemContextButtonClickListener;
    }

    public void setItemContextButtonClickListener(OnRecyclerItemContextButtonClickListener itemContextButtonClickListener) {
        this.itemContextButtonClickListener = itemContextButtonClickListener;
    }
}
