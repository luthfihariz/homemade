package com.luthfihariz.homemade.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by luthfihariz on 12/5/17.
 */

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false);
}