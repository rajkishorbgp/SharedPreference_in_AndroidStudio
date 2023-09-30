package com.rajkishorbgp.sessionmanager

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class SessionManajer {
    private lateinit var psef:SharedPreferences
    private lateinit var editor: Editor
    private lateinit var context: Context


    var FILE_NAME = "userDetails"
    val USER_NAME = "userName"
    val USER_EMAIL= "userEmail"
    val USER_PASSWORD= "userPassword"

    constructor(context: Context){
        this.psef=context.getSharedPreferences(FILE_NAME,0)
        this.editor=psef.edit()
        this.context=context
    }

    fun createSession(userName:String,userEmail:String,userPassword:String){
        editor.putString(USER_NAME,userName)
        editor.putString(USER_EMAIL,userEmail)
        editor.putString(USER_PASSWORD,userPassword)
        editor.apply()
    }

    fun getSessionData(key:String): String? {
        return psef.getString(key,null)
    }

    fun updateSessionData(key:String){
        editor.putString(key,null)
        editor.apply()
    }

    fun logoutSession(){
        editor.clear()
        editor.commit()
    }

}