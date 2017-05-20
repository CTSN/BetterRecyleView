package com.roy.betterrecyleview

import android.content.Context
import android.util.AttributeSet

/**
 * Created by roy on 2017/3/9.
 */

class FeedRootRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : BetterRecyclerView(context, attrs, defStyle) {

    override fun requestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        /* do nothing */
    }
}
