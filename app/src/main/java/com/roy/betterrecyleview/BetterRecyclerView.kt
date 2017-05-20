package com.roy.betterrecyleview

import android.content.Context
import android.support.v4.view.MotionEventCompat
import android.support.v4.view.ViewConfigurationCompat
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewConfiguration

/**
 * 支持嵌套横向recyleview
 * Created by roy on 2017/3/9.
 */

open class BetterRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : RecyclerView(context, attrs, defStyle) {
    private var mScrollPointerId = INVALID_POINTER
    private var mInitialTouchX: Int = 0
    private var mInitialTouchY: Int = 0
    private var mTouchSlop: Int = 0

    init {
        val vc = ViewConfiguration.get(getContext())
        mTouchSlop = vc.scaledTouchSlop
    }

    override fun setScrollingTouchSlop(slopConstant: Int) {
        super.setScrollingTouchSlop(slopConstant)
        val vc = ViewConfiguration.get(context)
        when (slopConstant) {
            RecyclerView.TOUCH_SLOP_DEFAULT -> mTouchSlop = vc.scaledTouchSlop
            RecyclerView.TOUCH_SLOP_PAGING -> mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(vc)
            else -> {
            }
        }
    }

    override fun onInterceptTouchEvent(e: MotionEvent): Boolean {

        val action = MotionEventCompat.getActionMasked(e)
        val actionIndex = MotionEventCompat.getActionIndex(e)

        when (action) {
            MotionEvent.ACTION_DOWN -> {
                mScrollPointerId = MotionEventCompat.getPointerId(e, 0)
                mInitialTouchX = (e.x + 0.5f).toInt()
                mInitialTouchY = (e.y + 0.5f).toInt()
                return super.onInterceptTouchEvent(e)
            }

            MotionEventCompat.ACTION_POINTER_DOWN -> {
                mScrollPointerId = MotionEventCompat.getPointerId(e, actionIndex)
                mInitialTouchX = (MotionEventCompat.getX(e, actionIndex) + 0.5f).toInt()
                mInitialTouchY = (MotionEventCompat.getY(e, actionIndex) + 0.5f).toInt()
                return super.onInterceptTouchEvent(e)
            }

            MotionEvent.ACTION_MOVE -> {
                val index = MotionEventCompat.findPointerIndex(e, mScrollPointerId)
                if (index < 0) {
                    return false
                }

                val x = (MotionEventCompat.getX(e, index) + 0.5f).toInt()
                val y = (MotionEventCompat.getY(e, index) + 0.5f).toInt()
                if (scrollState != RecyclerView.SCROLL_STATE_DRAGGING) {
                    val dx = x - mInitialTouchX
                    val dy = y - mInitialTouchY
                    val canScrollHorizontally = layoutManager.canScrollHorizontally()
                    val canScrollVertically = layoutManager.canScrollVertically()
                    var startScroll = false
                    if (canScrollHorizontally && Math.abs(dx) > mTouchSlop && (Math.abs(dx) >= Math.abs(dy) || canScrollVertically)) {
                        startScroll = true
                    }
                    if (canScrollVertically && Math.abs(dy) > mTouchSlop && (Math.abs(dy) >= Math.abs(dx) || canScrollHorizontally)) {
                        startScroll = true
                    }
                    return startScroll && super.onInterceptTouchEvent(e)
                }
                return super.onInterceptTouchEvent(e)
            }

            else -> return super.onInterceptTouchEvent(e)
        }
    }

    companion object {
        private val INVALID_POINTER = -1
    }
}
