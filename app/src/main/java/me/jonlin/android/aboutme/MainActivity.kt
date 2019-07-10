package me.jonlin.android.aboutme

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val doneButton = findViewById<Button>(R.id.done_button)
        doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(v: View) {
        val nicknameText = findViewById<TextView>(R.id.nickname_text)
        val nicknameEdit = findViewById<EditText>(R.id.nickname_edit)

        //setting visibility
        v.visibility = View.GONE //buton
        nicknameEdit.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE

        nicknameText.text = nicknameEdit.text

        //keyboard input
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }
}
