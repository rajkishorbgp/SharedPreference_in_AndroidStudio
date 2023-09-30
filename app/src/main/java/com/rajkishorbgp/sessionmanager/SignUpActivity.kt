package com.rajkishorbgp.sessionmanager

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText

class SignUpActivity : AppCompatActivity() {
    private lateinit var userName: TextInputEditText
    private lateinit var userEmail: TextInputEditText
    private lateinit var userPassword: TextInputEditText
    private lateinit var userConfirmPassword: TextInputEditText
    private lateinit var signUpButton: AppCompatButton
    private lateinit var signIpRedirectText: TextView
    private lateinit var sessionManajer: SessionManajer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        userName = findViewById(R.id.userName)
        userEmail= findViewById(R.id.userEmail)
        userPassword = findViewById(R.id.userPassword)
        userConfirmPassword = findViewById(R.id.userConfirmPassword)
        signUpButton = findViewById(R.id.signUpButton)
        signIpRedirectText = findViewById(R.id.signIpRedirectText)
        sessionManajer = SessionManajer(applicationContext)

        signUpButton.setOnClickListener {
            if (userName.text!!.isNotEmpty() && userEmail.text!!.isNotEmpty() && userPassword.text!!.isNotEmpty() && userConfirmPassword.text!!.isNotEmpty()) {
                if (userPassword.text.toString()==userConfirmPassword.text.toString()) {
                    sessionManajer.createSession(userName.text.toString(), userEmail.text.toString(), userPassword.text.toString())
                    startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                }else{
                    Toast.makeText(this@SignUpActivity,"Password does not match",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@SignUpActivity,"Please fill in all lines",Toast.LENGTH_SHORT).show()
            }
        }

       signIpRedirectText.setOnClickListener {
           startActivity(Intent(this,SignInActivity::class.java))
       }
    }
}