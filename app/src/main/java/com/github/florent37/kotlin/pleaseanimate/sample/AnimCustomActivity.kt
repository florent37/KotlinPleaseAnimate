package com.github.florent37.kotlin.pleaseanimate.sample

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.github.florent37.kotlin.pleaseanimate.core.Expectations
import com.github.florent37.kotlin.pleaseanimate.core.custom.CustomAnimExpectation
import com.github.florent37.kotlin.pleaseanimate.please
import kotlinx.android.synthetic.main.activity_custom.*

class AnimCustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        var big = false

        val startSize = 14f
        val endSize = 25f

        text_resize.setOnClickListener {
            if(!big) {
                please {
                    animate(text_resize) toBe {
                        textSize(startSize, endSize)
                    }
                }.start()

                big = true
            } else {
                please {
                    animate(text_resize) toBe {
                        textSize(endSize, startSize)
                    }
                }.start()

                big = false
            }
        }
    }

    private class TextSizeAnimExpectation(private val startSize: Float,
                                          private val endSize: Float): CustomAnimExpectation() {

        override fun getAnimator(viewToMove: View): Animator? {
            return if(viewToMove is TextView) {
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

    private fun Expectations.textSize(startSize: Float, endSize: Float): CustomAnimExpectation {
        return TextSizeAnimExpectation(startSize, endSize).apply {
            expectations.add(this)
        }
    }
}