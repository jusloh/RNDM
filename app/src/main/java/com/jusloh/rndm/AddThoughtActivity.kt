/*
 * Created by Justin Loh on 28/6/19 1:17 PM
 * Last modifiled 28/6/19 1:03 PM.
 * Copyright (c) 2019. All rights reserved.
 */

package com.jusloh.rndm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_thought.*

class AddThoughtActivity : AppCompatActivity() {

    var selectedCategory = FUNNY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_thought)
    }

    fun addPostClicked(view: View) {
        // add post to Firestore!

        val data = HashMap<String, Any>()
        data.put("category", selectedCategory)
        data.put("numComments", 0)
        data.put("numLikes", 0)
        data.put("thoughtTxt", addThoughtTxt.text.toString())
        data.put("timestamp", FieldValue.serverTimestamp())
        data.put("username", addUsernameTxt.text.toString())

        FirebaseFirestore.getInstance().collection(THOUGHTS_REF)
            .add(data)
            .addOnSuccessListener {
                finish()
            }
            .addOnFailureListener { exception ->
                Log.e("Exception", "Could not add post: $exception")
            }
    }

    fun addFunnyClicked(view: View) {
        if (selectedCategory == FUNNY) {
            addFunnyBtn.isChecked = true
            return
        }
        addSeriousBtn.isChecked = false
        addCrazyBtn.isChecked = false
        selectedCategory = FUNNY
    }

    fun addSeriousClicked(view: View) {
        if (selectedCategory == SERIOUS) {
            addSeriousBtn.isChecked = true
            return
        }
        addFunnyBtn.isChecked = false
        addCrazyBtn.isChecked = false
        selectedCategory = SERIOUS
    }

    fun addCrazyClicked(view: View) {
        if (selectedCategory == CRAZY) {
            addCrazyBtn.isChecked = true
            return
        }
        addSeriousBtn.isChecked = false
        addFunnyBtn.isChecked = false
        selectedCategory = CRAZY
    }
}
