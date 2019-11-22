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
            holder.ivFeedCenter.setImageResource(R.drawable.img_feed_center_1);
            holder.ivFeedBottom.setImageResource(R.drawable.img_feed_bottom_1);
        } else {
            holder.ivFeedCenter.setImageResource(R.drawable.img_feed_center_2);
            holder.ivFeedBottom.setImageResource(R.drawable.img_feed_bottom_2);
        }

        holder.btnComments.setTag(position);
        holder.btnMore.setTag(position);
        holder.ivFeedCenter.setTag(holder);
        holder.btnLike.setTag(holder);

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
        ImageView ivFeedCenter;
        ImageView ivFeedBottom;
        ImageButton btnComments;
        ImageButton btnLike;
        ImageButton btnMore;
        TextSwitcher tsLikesCounter;
        ImageView ivUserProfile;
        FrameLayout vImageRoot;

        CellFeedViewHolder(View view) {
            super(view);
            ivadmin = (TextView) view.findViewById(R.id.ivAdminText);
            ivFeedCenter = (ImageView) view.findViewById(R.id.ivFeedCenter);
            ivFeedBottom = (ImageView) view.findViewById(R.id.ivFeedBottom);
            btnComments = (ImageButton) view.findViewById(R.id.btnComments);
            btnLike = (ImageButton) view.findViewById(R.id.btnLike);
            btnMore = (ImageButton) view.findViewById(R.id.btnMore);
            tsLikesCounter = (TextSwitcher) view.findViewById(R.id.tsLikesCounter);
            vImageRoot = (FrameLayout) view.findViewById(R.id.vImageRoot);
        }
    }


}
