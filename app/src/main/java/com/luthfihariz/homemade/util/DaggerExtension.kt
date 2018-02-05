package com.luthfihariz.homemade.util

import android.support.v7.app.AppCompatActivity
import com.luthfihariz.homemade.HomemadeApplication
import com.luthfihariz.homemade.di.AppComponent

/**
 * Created by luthfihariz on 02/02/18.
 */
val AppCompatActivity.component: AppComponent
    get() = (application as HomemadeApplication).appComponent