package com.rajkishorbgp.sessionmanager

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText

class SignInActivity : AppCompatActivity() {
    private lateinit var userEmail:TextInputEditText
    private lateinit var userPassword:TextInputEditText
    private lateinit var signIpButton:AppCompatButton
    private lateinit var sessionManajer: SessionManajer
    private lateinit var signupRedirectText:TextView
    private lateinit var forgotPassword:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        userEmail= findViewById(R.id.userEmail)
        userPassword = findViewById(R.id.userPassword)
        signIpButton = findViewById(R.id.signInButton)
        sessionManajer = SessionManajer(applicationContext)
        signupRedirectText = findViewById(R.id.signupRedirectText)
        forgotPassword = findViewById(R.id.forgotPassword)


        signIpButton.setOnClickListener {
            if (userEmail.text!!.isNotEmpty() && userEmail.text!!.isNotEmpty() ){
                if (userEmail.text.toString() == sessionManajer.getSessionData(sessionManajer.USER_EMAIL) &&
                    userPassword.text.toString() == sessionManajer.getSessionData(sessionManajer.USER_PASSWORD)){
                    startActivity(Intent(this@SignInActivity,MainActivity::class.java))
                }else{
                    Toast.makeText(this,"Wrong Email and Password",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Please fill in all lines",Toast.LENGTH_SHORT).show()
            }
        }

        signupRedirectText.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }
        forgotPassword.setOnClickListener {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
        }
    }
}