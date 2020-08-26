package com.github.florent37.kotlin.pleaseanimate.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Gravity
import androidx.core.widget.NestedScrollView
import com.github.florent37.kotlin.pleaseanimate.please
import kotlinx.android.synthetic.main.activity_scroll.*


class AnimScrollActivity : AppCompatActivity() {

    internal var h: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)

        h = resources.getDimensionPixelOffset(R.dimen.height)

        val animation = please {
            animate(avatar) toBe {
                topOfItsParent(marginDp = 20f)
                leftOfItsParent(marginDp = 20f)
                scale(0.5f, 0.5f)
            }

            animate(username) toBe {
                rightOf(avatar, marginDp = 16f)
                sameCenterVerticalAs(avatar)

                alpha(0.5f)
            }

            animate(revert) toBe {
                rightOfItsParent(marginDp = 20f)
                sameCenterVerticalAs(avatar)
            }

            animate(background) toBe {
                height(h, horizontalGravity = Gravity.LEFT, verticalGravity = Gravity.TOP)
            }
        }

        scrollview.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, _, scrollY, _, _ ->
            val percent = scrollY * 1f / v.maxScrollAmount
            animation.setPercent(percent)
        })
    }

}
