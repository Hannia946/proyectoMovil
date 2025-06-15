package com.example.proyecto

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.cliente.CalificacionEnvioActivity
import com.example.proyecto.databinding.ItemEnvioBinding

class EnvioAdapter(private val contexto: Context, private val listaEnvios: MutableList<Envio>) : RecyclerView.Adapter<EnvioAdapter.EnvioViewHolder>() {

    inner class EnvioViewHolder(val binding: ItemEnvioBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnvioViewHolder {
        val binding = ItemEnvioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EnvioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EnvioViewHolder, position: Int) {
        val envio = listaEnvios[position]
        with(holder.binding) {
            tvIdEnvio.text= "ID: ${envio.id}"
            tvRemitente.text = "Remitente: ${envio.nombreRemitente} ${envio.apellidoRemitente}"
            tvDestinatario.text = "Destinatario: ${envio.nombreDestinatario} ${envio.apellidoDestinatario}"
            tvDireccionOrigen.text = "Origen: ${envio.calleRemitente} ${envio.noRemitente}, ${envio.coloniaRemitente}, ${envio.estadoRemitente}"
            tvDireccionDestino.text = "Destino: ${envio.calleDestinatario} ${envio.noDestinatario}, ${envio.coloniaDestinatario}, ${envio.estadoDestinatario}"
            btnCalificar.setOnClickListener{calificacion(envio)}
        }

    }

    private fun calificacion(envio :Envio) {
        val intent = Intent(contexto, CalificacionEnvioActivity::class.java).apply {
            putExtra("id", envio.id.toString())
            putExtra("calle", envio.calleRemitente)
            putExtra("no", envio.noRemitente)
            putExtra("colonia", envio.coloniaRemitente)
            putExtra("estado", envio.estadoRemitente)

            putExtra("calleD", envio.calleDestinatario)
            putExtra("noD", envio.noDestinatario)
            putExtra("coloniaD", envio.coloniaDestinatario)
            putExtra("estadoD", envio.estadoDestinatario)

        }
        contexto.startActivity(intent)
    }


    override fun getItemCount(): Int = listaEnvios.size
}