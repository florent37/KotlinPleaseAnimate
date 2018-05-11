package com.github.florent37.kotlin.pleaseanimate.core.custom

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.View
import android.widget.TextView
import com.github.florent37.kotlin.pleaseanimate.core.Utils

class TextSizeAnimExpectation(private val endSize: Float): CustomAnimExpectation() {

    override fun getAnimator(viewToMove: View): Animator? {
        return if(viewToMove is TextView) {

            val startSize = Utils.spToDp(viewToMove.context, viewToMove.textSize)
            ValueAnimator.ofFloat(startSize, endSize).apply {
                addUpdateListener {
                    val value = it.animatedValue as Float
                    viewToMove.textSize = value
                }
            }
        } else
            null
    }
}