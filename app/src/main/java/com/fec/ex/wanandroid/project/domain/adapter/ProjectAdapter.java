package com.fec.ex.wanandroid.project.domain.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.base.GlideApp;
import com.fec.ex.wanandroid.project.domain.model.ProjectList;

import java.util.List;

/**
 * Created by Fe2Cu on 07.09.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class ProjectAdapter extends BaseQuickAdapter<ProjectList.DatasBean, BaseViewHolder> {

    public ProjectAdapter(int layoutResId, @Nullable List<ProjectList.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, ProjectList.DatasBean item) {
        viewHolder.setText(R.id.tvTitle, item.getTitle())
                .setText(R.id.tvAuthor, item.getAuthor())
                .setText(R.id.tvDesc, item.getDesc());
        GlideApp.with(mContext)
                .load(item.getEnvelopePic())
                .placeholder(R.drawable.ic_android_holder)
                .into((ImageView) viewHolder.getView(R.id.ivArticleImage));
    }
}
