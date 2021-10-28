package com.curso.projetojuneko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.curso.projetojuneko.Activity.Login

class SplashScreen : AppCompatActivity() {
    private val timeOut: Long = 5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Método delay para passar de uma activity para outra
        Handler().postDelayed({
            startActivity(Intent(this, Login::class.java))
            finish()
        }, timeOut)

    }

}