package com.roy.betterrecyleview

import android.content.Context
import android.support.v4.view.NestedScrollingParent
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout

/**
 * Created by roy on 2017/3/20.
 */

class TestStickLayout : LinearLayout, NestedScrollingParent {

    override fun onStartNestedScroll(child: View, target: View, nestedScrollAxes: Int): Boolean {
        Log.e(TAG, "onStartNestedScroll")
        return true
    }

    override fun onNestedScrollAccepted(child: View, target: View, nestedScrollAxes: Int) {
        Log.e(TAG, "onNestedScrollAccepted")
    }

    override fun onStopNestedScroll(target: View) {
        Log.e(TAG, "onStopNestedScroll")
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
        Log.e(TAG, "onNestedScroll")
    }

    //滑动
    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
        //        Log.e(TAG, "onNestedPreScroll");
        //        boolean hiddenTop = dy > 0 && getScrollY() < mTopViewHeight;
        //        boolean showTop = dy < 0 && getScrollY() >= 0 && !ViewCompat.canScrollVertically(target, -1);
        //
        //        if (hiddenTop || showTop)
        //        {
        //            scrollBy(0, dy);
        //            consumed[1] = dy;
        //        }
    }

    override fun onNestedFling(target: View, velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
        Log.e(TAG, "onNestedFling")
        return false
    }

    //滑动拦截
    override fun onNestedPreFling(target: View, velocityX: Float, velocityY: Float): Boolean {
        Log.e(TAG, "onNestedPreFling")
        //down - //up+
        //        if (getScrollY() >= mTopViewHeight) return false;
        //        fling((int) velocityY);
        return true
    }

    override fun getNestedScrollAxes(): Int {
        Log.e(TAG, "getNestedScrollAxes")
        return 0
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    companion object {
        val TAG = "TestStickLayout"
    }
}
