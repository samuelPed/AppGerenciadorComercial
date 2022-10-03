package com.curso.projetojuneko.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.curso.projetojuneko.databinding.ActivityNovoPedidoBinding

class NovoPedidoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNovoPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNovoPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}