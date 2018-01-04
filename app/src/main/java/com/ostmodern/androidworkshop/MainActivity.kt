package com.ostmodern.androidworkshop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topLeftBtn.setOnClickListener { animateBias(root, 0f, 0f) }

        centerBtn.setOnClickListener { animateBiasViaLayout(root) }

        topRightBtn.setOnClickListener { animateBias(root, 1f, 0f) }
    }

    // Programmatically
    private fun animateBias(root: ConstraintLayout, horizontalBias: Float, verticalBias: Float) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(root)
        constraintSet.setHorizontalBias(R.id.textView, horizontalBias)
        constraintSet.setVerticalBias(R.id.textView, verticalBias)
        TransitionManager.beginDelayedTransition(root)
        constraintSet.applyTo(root)
    }

    // Alternative Via Layout
    private fun animateBiasViaLayout(root: ConstraintLayout) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(root.context, R.layout.activity_main_suprise)
        TransitionManager.beginDelayedTransition(root)
        constraintSet.applyTo(root)
    }
}