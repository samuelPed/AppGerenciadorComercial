package com.curso.projetojuneko.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.curso.projetojuneko.R
import java.text.DateFormat
import java.util.*

class AdapterPedido : RecyclerView.Adapter<AdapterPedido.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var nomeCliente: String
        lateinit var dtPedido: String
        lateinit var statusPedido: String
        var qtItem: Int = 0


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")

        val itemLista = LayoutInflater.from(parent.context).inflate(R.layout.adapter_h_pedido, parent, false)

        return MyViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}