package com.iamrajendra.myapplication;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by rajendraverma on 12-08-2016.
 */
public class VerticalSpaceItemDecoration   extends RecyclerView.ItemDecoration {

private final int mVerticalSpaceHeight;

public VerticalSpaceItemDecoration(int mVerticalSpaceHeight) {
        this.mVerticalSpaceHeight = mVerticalSpaceHeight;
        }

@Override
public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                           RecyclerView.State state) {
        outRect.bottom = mVerticalSpaceHeight;
        }
        }
