package com.rajkishorbgp.sessionmanager

import android.annotation.SuppressLint
import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var person: TextView
    private lateinit var logoutButton: Button
    private lateinit var sessionManajer: SessionManajer


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        person = findViewById(R.id.personName)
        logoutButton = findViewById(R.id.logoutButton)
        sessionManajer = SessionManajer(applicationContext)

        person.text=sessionManajer.getSessionData(sessionManajer.USER_NAME)
        logoutButton.setOnClickListener {
            sessionManajer.logoutSession()
            startActivity(Intent(this,SignInActivity::class.java))
            Toast.makeText(this,"Log out", Toast.LENGTH_SHORT).show()
        }
    }
}