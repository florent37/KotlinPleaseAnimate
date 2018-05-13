package com.github.florent37.kotlin.pleaseanimate.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.florent37.kotlin.pleaseanimate.please
import kotlinx.android.synthetic.main.activity_margin.*

class AnimMarginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_margin)

        var topAnim = HOR_ANIMS.NONE
        var bottomAnim = VER_ANIMS.NONE
        var isLastRight = false
        var isLastTop = false

        topCard.setOnClickListener {

            when {
                topAnim == HOR_ANIMS.NONE && !isLastRight -> {
                    please {
                        animate(topCard) toBe {
                            marginRight(48f)
                        }
                    }.start()

                    topAnim = HOR_ANIMS.RIGHT
                    isLastRight = true
                }

                topAnim == HOR_ANIMS.NONE && isLastRight -> {
                    please {
                        animate(topCard) toBe {
                            marginLeft(48f)
                        }
                    }.start()

                    topAnim = HOR_ANIMS.LEFT
                    isLastRight = false
                }

                topAnim == HOR_ANIMS.LEFT -> {
                    please {
                        animate(topCard) toBe {
                            marginLeft(8f)
                        }
                    }.start()

                    topAnim = HOR_ANIMS.NONE
                }

                topAnim == HOR_ANIMS.RIGHT -> {
                    please {
                        animate(topCard) toBe {
                            marginRight(8f)
                        }
                    }.start()

                    topAnim = HOR_ANIMS.NONE
                }
            }
        }


        bottomCard.setOnClickListener {

            when {
                bottomAnim == VER_ANIMS.NONE && !isLastTop -> {
                    please {
                        animate(bottomCard) toBe {
                            marginTop(48f)
                        }
                    }.start()

                    bottomAnim = VER_ANIMS.TOP
                    isLastTop = true
                }

                bottomAnim == VER_ANIMS.NONE && isLastTop -> {
                    please {
                        animate(bottomCard) toBe {
                            marginBottom(48f)
                        }
                    }.start()

                    bottomAnim = VER_ANIMS.BOTTOM
                    isLastTop = false
                }

                bottomAnim == VER_ANIMS.BOTTOM -> {
                    please {
                        animate(bottomCard) toBe {
                            marginBottom(8f)
                        }
                    }.start()

                    bottomAnim = VER_ANIMS.NONE
                }

                bottomAnim == VER_ANIMS.TOP -> {
                    please {
                        animate(bottomCard) toBe {
                            marginTop(8f)
                        }
                    }.start()

                    bottomAnim = VER_ANIMS.NONE
                }
            }
        }
    }

    private enum class HOR_ANIMS {
        RIGHT, LEFT, NONE
    }

    private enum class VER_ANIMS {
        TOP, BOTTOM, NONE
    }
}