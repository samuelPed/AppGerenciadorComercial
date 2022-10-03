package com.curso.projetojuneko.activity

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.curso.projetojuneko.R
import com.curso.projetojuneko.databinding.ActivityCozinhaBinding

class CozinhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCozinhaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCozinhaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}