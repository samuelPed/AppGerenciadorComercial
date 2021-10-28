package com.curso.projetojuneko.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.curso.projetojuneko.R

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun telaRecuperaSenha(view: View){
        val intent = Intent(this, EsqueceuSenha::class.java)
        startActivity(intent)
    }
}