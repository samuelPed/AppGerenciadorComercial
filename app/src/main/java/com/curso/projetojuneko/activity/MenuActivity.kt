package com.curso.projetojuneko.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.curso.projetojuneko.R
import com.curso.projetojuneko.databinding.ActivityMenuBinding
import com.google.firebase.database.*

class MenuActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var usuarios: DatabaseReference
    private lateinit var binding : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*usuarios = FirebaseDatabase.getInstance().getReference("usuarios").child("atendentes").child("userId").child("status")

        TODO("CAPTAR O VALOR STATUS NO DATABASE PARA VERIFICAR SE O USUÁRIO É ATEN OU GEREN OU ADM")
        Toast.makeText(this, usuarios.toString(), Toast.LENGTH_LONG).show()


        if(usuarios.child("atendentes").child("userId").child("status").equals("Atendente")){
            btn_saldo.visibility = View.GONE
            btn_add_colaborador.visibility = View.GONE
        }else if(usuarios.child("gerentes").child("userId").child("status").equals("Gerente")){
            btn_add_colaborador.visibility = View.GONE
        }*/

        binding.btnAddUsuario.setOnClickListener(this)
        binding.btnSaldo.setOnClickListener(this)
    }

    override fun onClick(view : View) {
        val id = view.id
        if(id == R.id.btn_add_usuario){
            startActivity(Intent(this, CadastrarColaboradorActivity::class.java))
        }else if(id == R.id.btn_saldo){

        }

    }
}