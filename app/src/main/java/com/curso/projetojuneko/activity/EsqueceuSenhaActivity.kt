package com.curso.projetojuneko.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.curso.projetojuneko.R
import com.curso.projetojuneko.databinding.ActivityEsqueceuSenhaBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EsqueceuSenhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEsqueceuSenhaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEsqueceuSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)





    }
}