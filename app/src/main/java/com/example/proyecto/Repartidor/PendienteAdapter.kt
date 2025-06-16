package com.example.proyecto.repartidor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.Envio
import com.example.proyecto.EnvioAdapter.EnvioViewHolder
import com.example.proyecto.databinding.ItemEnvioBinding
import com.example.proyecto.databinding.ItemPendienteBinding


class PendienteAdapter(private val contexto: Context, private val listaEnvios: MutableList<Envio>) : RecyclerView.Adapter<PendienteAdapter.PendienteViewHolder>() {

    inner class PendienteViewHolder(val binding: ItemPendienteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendienteViewHolder {
        val binding = ItemPendienteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PendienteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PendienteViewHolder, position: Int) {
        val envio = listaEnvios[position]
        with(holder.binding) {

            tvIdEnvioT.text= "ID: ${envio.id}"
            tvRemitente.text = "Remitente: ${envio.nombreRemitente} ${envio.apellidoRemitente}"
            tvDestinatario.text = "Destinatario: ${envio.nombreDestinatario} ${envio.apellidoDestinatario}"
            tvDireccionOrigen.text = "Origen: ${envio.calleRemitente} ${envio.noRemitente}, ${envio.coloniaRemitente}, ${envio.estadoRemitente}"
            tvDireccionDestino.text = "Destino: ${envio.calleDestinatario} ${envio.noDestinatario}, ${envio.coloniaDestinatario}, ${envio.estadoDestinatario}"


        }

    }

    override fun getItemCount(): Int = listaEnvios.size
}