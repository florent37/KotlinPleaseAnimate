package com.github.florent37.kotlin.pleaseanimate.core.margins

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.View
import android.view.ViewGroup
import com.github.florent37.kotlin.pleaseanimate.core.Utils.dpToPx
import com.github.florent37.kotlin.pleaseanimate.core.Utils.pxToDp
import com.github.florent37.kotlin.pleaseanimate.core.custom.CustomAnimExpectation

class MarginSetAnimExpectation(
        private val marginValue: Float,
        private val margin: Margin) : CustomAnimExpectation() {

    override fun getAnimator(viewToMove: View): Animator? {
        val params = viewToMove.layoutParams

        return if(params is ViewGroup.MarginLayoutParams) {

            val end = dpToPx(viewToMove.context, marginValue)
            val start = when(margin) {
                Margin.TOP -> pxToDp(viewToMove.context, params.topMargin.toFloat())
                Margin.BOTTOM -> pxToDp(viewToMove.context, params.bottomMargin.toFloat())
                Margin.RIGHT -> pxToDp(viewToMove.context, params.rightMargin.toFloat())
                Margin.LEFT -> pxToDp(viewToMove.context, params.leftMargin.toFloat())
            }

            when(margin) {
                Margin.TOP -> ValueAnimator.ofInt(start.toInt(), end.toInt()).apply {
                    addUpdateListener {
                        params.topMargin = it.animatedValue as Int
                        viewToMove.requestLayout()
                    }
                }

                Margin.BOTTOM -> ValueAnimator.ofInt(start.toInt(), end.toInt()).apply {
                    addUpdateListener {
                        params.bottomMargin = it.animatedValue as Int
                        viewToMove.requestLayout()
                    }
                }

                Margin.RIGHT -> ValueAnimator.ofInt(start.toInt(), end.toInt()).apply {
                    addUpdateListener {
                        params.rightMargin = it.animatedValue as Int
                        viewToMove.requestLayout()
                    }
                }

                Margin.LEFT -> ValueAnimator.ofInt(start.toInt(), end.toInt()).apply {
                    addUpdateListener {
                        params.leftMargin = it.animatedValue as Int
                        viewToMove.requestLayout()
                    }
                }
            }
        } else
            null
    }
}