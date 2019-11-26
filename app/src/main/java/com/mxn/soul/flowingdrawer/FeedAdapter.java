package com.mxn.soul.flowingdrawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;


class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private int itemsCount = 0;

    FeedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_feed, parent, false);

        return new CellFeedViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final CellFeedViewHolder holder = (CellFeedViewHolder) viewHolder;
        bindDefaultFeedItem(position, holder);
    }

    private void bindDefaultFeedItem(int position, CellFeedViewHolder holder) {
        if (position % 2 == 0) { //게시판 글올리는 부분
            holder.ivFeedCenter.setText("바보");

        } else {
            holder.ivFeedCenter.setText("멍청이");

        }


        holder.ivFeedCenter.setTag(holder);


    }

    void updateItems() {
        itemsCount = 10;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getItemCount() {
        return itemsCount;
    }

    private static class CellFeedViewHolder extends RecyclerView.ViewHolder {
        TextView  ivadmin;
        TextView ivFeedCenter;


        FrameLayout vImageRoot;

        CellFeedViewHolder(View view) {
            super(view);
            ivadmin = (TextView) view.findViewById(R.id.ivAdminText);
            ivFeedCenter = (TextView) view.findViewById(R.id.ivFeedCenter);

            vImageRoot = (FrameLayout) view.findViewById(R.id.vImageRoot);
        }
    }


}
