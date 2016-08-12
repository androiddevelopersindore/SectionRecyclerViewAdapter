package com.iamrajendra.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iamrajendra.myapplication.R;
import com.iamrajendra.myapplication.model.SectionItem;

import java.util.List;

/**
 * Created by rajendraverma on 11-08-2016.
 */
public class SectionRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity mActivity;
    private Context mContext;
    private List<SectionItem> mlist_sectionaAndItem;
    private int section = 0;
    private int item = 1;

    public SectionRecyclerViewAdapter(Activity mActivity, Context mContext, List<SectionItem> mlist_sectionaAndItem) {
        this.mActivity = mActivity;
        this.mContext = mContext;
        this.mlist_sectionaAndItem = mlist_sectionaAndItem;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = mActivity.getLayoutInflater();
        View view = null;
        if (viewType == section) {
            view = layoutInflater.inflate(R.layout.header, null);
            return new SectionView(view);

        } else {
            view = layoutInflater.inflate(R.layout.item, null);
            return new ItemView(view);

        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        if (viewType == section) {
        SectionView sectionView = (SectionView) holder;
            sectionView.mTextView_header.setText(mlist_sectionaAndItem.get(position).getHeader());

        } else {
        ItemView itemView = (ItemView) holder;
            itemView.mTextView_item.setText(mlist_sectionaAndItem.get(position).getItem());
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (mlist_sectionaAndItem.get(position).getHeader() == null) {
            return item;
        } else {
            return section;
        }


    }

    @Override
    public int getItemCount() {
        return mlist_sectionaAndItem.size();
    }

    public class SectionView extends RecyclerView.ViewHolder {
        private TextView mTextView_header;
        public SectionView(View itemView) {
            super(itemView);
            mTextView_header = (TextView)itemView.findViewById(R.id.header);
        }
    }


    public class ItemView extends RecyclerView.ViewHolder {
        private TextView mTextView_item;
        public ItemView(View itemView) {
            super(itemView);
            mTextView_item = (TextView)itemView.findViewById(R.id.item);
        }
    }
}
