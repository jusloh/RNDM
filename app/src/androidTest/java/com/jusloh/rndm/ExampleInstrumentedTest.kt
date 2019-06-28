/*
 * Created by Justin Loh on 28/6/19 1:17 PM
 * Last modifiled 27/6/19 3:02 PM.
 * Copyright (c) 2019. All rights reserved.
 */

package com.jusloh.rndm

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.jusloh.rndm", appContext.packageName)
    }
}
