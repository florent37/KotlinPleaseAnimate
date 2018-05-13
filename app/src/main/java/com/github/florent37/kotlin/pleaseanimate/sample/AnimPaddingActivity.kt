package com.github.florent37.kotlin.pleaseanimate.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.florent37.kotlin.pleaseanimate.please
import kotlinx.android.synthetic.main.activity_padding.*

class AnimPaddingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_padding)

        var expanded = false

        card.setOnClickListener {

            if(!expanded) {

                please {
                    animate(title_text) toBe {
                        paddingBottom(64f)
                    }
                    animate(text) toBe {
                        paddingBottom(32f)
                    }

                    animate(icon2) toBe {
                        paddingLeft(24f)
                        paddingRight(24f)
                    }
                }.start()

                expanded = true
            } else {

                please {
                    animate(title_text) toBe {
                        paddingBottom(0f)
                    }
                    animate(text) toBe {
                        paddingBottom(0f)
                    }

                    animate(icon2) toBe {
                        paddingLeft(0f)
                        paddingRight(0f)
                    }
                }.start()

                expanded = false
            }
        }
    }
}