package com.curso.projetojuneko.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.curso.projetojuneko.R
import com.curso.projetojuneko.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAddPedido.setOnClickListener(this)
        binding.openMenu.setOnClickListener(this)


    }

    override fun onClick(view : View) {
        val id = view.id
        if(id == R.id.fabAddPedido){
            startActivity(Intent(this, NovoPedidoActivity::class.java))
        }

        if (id == R.id.openMenu){
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}

