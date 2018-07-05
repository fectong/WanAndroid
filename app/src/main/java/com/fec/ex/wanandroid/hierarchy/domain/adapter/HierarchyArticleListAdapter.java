package com.fec.ex.wanandroid.hierarchy.domain.adapter;

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
import com.fec.ex.wanandroid.hierarchy.domain.HierarchyArticleList;

import java.util.List;

/**
 * Created by Fe2Cu on 07.05.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class HierarchyArticleListAdapter extends RecyclerView.Adapter<HierarchyArticleListAdapter.ViewHolder> {

    private List<HierarchyArticleList.DatasBean> mHierarchyArticleList;
    private Context mContext;

    public HierarchyArticleListAdapter(List<HierarchyArticleList.DatasBean> hierarchyArticleList) {
        mHierarchyArticleList = hierarchyArticleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_article_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        HierarchyArticleList.DatasBean dataBean = mHierarchyArticleList.get(position);
        if (!(dataBean.getEnvelopePic().equals(""))) {
            Glide.with(mContext).load(dataBean.getEnvelopePic()).into(viewHolder.ivArticle);
        } else {
            viewHolder.ivArticle.setImageResource(R.drawable.ic_android_holder);
        }
        viewHolder.tvTitle.setText(dataBean.getTitle());
        viewHolder.tvAuthor.setText(dataBean.getAuthor());
        viewHolder.tvDesc.setText(dataBean.getDesc());
    }

    @Override
    public int getItemCount() {
        if (mHierarchyArticleList != null) {
            return mHierarchyArticleList.size();
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
        }
    }
}
