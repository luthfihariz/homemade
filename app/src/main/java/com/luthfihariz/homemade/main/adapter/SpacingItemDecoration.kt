package com.luthfihariz.homemade.main.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by luthfihariz on 12/18/17.
 */
class SpacingItemDecoration(
        private val verticalSpace: Int,
        private val padding: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) < parent.adapter.itemCount - 1) {
            outRect.bottom = verticalSpace
        } else {
            outRect.bottom = padding
        }
    }
}