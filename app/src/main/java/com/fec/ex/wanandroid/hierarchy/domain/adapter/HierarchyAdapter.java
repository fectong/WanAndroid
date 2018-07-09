package com.fec.ex.wanandroid.hierarchy.domain.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fec.ex.wanandroid.hierarchy.domain.HierarchyArticleList;
import com.fec.ex.wanandroid.R;

import java.util.List;

/**
 * Created by Fe2Cu on 07.09.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class HierarchyAdapter extends BaseQuickAdapter<HierarchyArticleList.DatasBean, BaseViewHolder> {

    public HierarchyAdapter(int layoutResId, @Nullable List<HierarchyArticleList.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, HierarchyArticleList.DatasBean item) {
        viewHolder.setText(R.id.tvTitle, item.getTitle())
                .setText(R.id.tvAuthor, item.getAuthor());
    }
}