package com.fec.ex.wanandroid.settings.mine.collection.domain.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.settings.mine.collection.domain.model.CollectionList;

import java.util.List;

/**
 * Created by Fe2Cu on 07.11.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class CollectionAdapter extends BaseQuickAdapter<CollectionList.DatasBean, BaseViewHolder> {


    public CollectionAdapter(int layoutResId, @Nullable List<CollectionList.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, CollectionList.DatasBean item) {
        viewHolder.setText(R.id.tvCollectionTitle, item.getTitle())
                .setText(R.id.tvCollectionTime, item.getNiceDate())
                .setText(R.id.tvCollectionChapter, item.getChapterName())
                .setText(R.id.tvCollectionAuthor, item.getAuthor());
    }
}
