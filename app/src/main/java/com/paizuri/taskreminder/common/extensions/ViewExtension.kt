package com.paizuri.taskreminder.common.extensions

import android.view.View

fun View.setOnClick(onViewClick: () -> Unit) {
    this.setOnClickListener {
        onViewClick()
    }
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}