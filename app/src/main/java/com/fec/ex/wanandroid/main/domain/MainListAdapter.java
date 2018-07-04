package com.fec.ex.wanandroid.main.domain;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fec.ex.wanandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fe2Cu on 07.04.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private List<MainArticleList.DatasBean> mArticleList;
    private Context mContext;

    private OnItemClickListener listener;

    public MainListAdapter(List<MainArticleList.DatasBean> articleList) {
        mArticleList = articleList;
    }

    public MainListAdapter() {
        mArticleList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_article_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MainArticleList.DatasBean dataBean = mArticleList.get(i);
        if (!(dataBean.getEnvelopePic().equals(""))) {
            Glide.with(mContext).load(dataBean.getEnvelopePic()).into(viewHolder.ivArticle);
        } else {
            viewHolder.ivArticle.setImageResource(R.mipmap.img_tmp);
        }
        viewHolder.tvTitle.setText(dataBean.getTitle());
        viewHolder.tvAuthor.setText(dataBean.getAuthor());
        viewHolder.tvDesc.setText(dataBean.getDesc());
    }

    @Override
    public int getItemCount() {
        if (mArticleList != null) {
            return mArticleList.size();
        } else {
            return 0;
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvAuthor;
        TextView tvDesc;
        ImageView ivArticle;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            ivArticle = itemView.findViewById(R.id.ivArticleImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


}
