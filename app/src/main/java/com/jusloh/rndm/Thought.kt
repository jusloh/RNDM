/*
 * Created by Justin Loh on 28/6/19 3:36 PM
 * Last modifiled 28/6/19 3:36 PM.
 * Copyright (c) 2019. All rights reserved.
 */

package com.jusloh.rndm

import java.util.*

data class Thought constructor(val username: String, val timestamp: Date, val thoughtTxt: String,
                               val numLikes: Int, val numComments: Int, val documentId: String)