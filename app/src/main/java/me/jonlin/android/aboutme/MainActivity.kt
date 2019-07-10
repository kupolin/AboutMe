package me.jonlin.android.aboutme

import android.app.Activity
import android.content.Context

import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import me.jonlin.android.aboutme.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var myName : MyName

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myName = MyName("Jonathan Lin", binding.nicknameEdit, binding.doneButton)
        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(v: View) {

        // setting visibility
         v.visibility = View.GONE //button

//        window.currentFocus?.visibility = View.GONE

        //this.myName.nickname = binding.nicknameEdit.text
//binding.myName?.nickname = binding.nicknameEdit.text
        binding.apply {
        //    nicknameText.text = binding.nicknameEdit.text
            // invalidates all binding expressions and requests a new rebind to refresh UI.
            //invalidateOptionsMenu() force refresh also updates without invalidateAll() works
            invalidateAll()
        //    nicknameEdit.visibility = View.GONE
        //    nicknameText.visibility = View.VISIBLE
        }


        //keyboard input
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }

}

