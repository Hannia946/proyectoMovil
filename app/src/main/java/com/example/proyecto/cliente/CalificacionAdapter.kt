package com.example.proyecto.cliente

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.Envio
import com.example.proyecto.EnvioAdapter
import com.example.proyecto.databinding.ItemCalificacionBinding

class CalificacionAdapter(private val contexto: Context, private val listaEnvios: MutableList<Envio>) : RecyclerView.Adapter<CalificacionAdapter.CalificarViewHolder>()  {

    inner class CalificarViewHolder(val binding: ItemCalificacionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalificacionAdapter.CalificarViewHolder {
        val binding = ItemCalificacionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalificarViewHolder(binding)
    }

    override fun getItemCount(): Int = listaEnvios.size

    override fun onBindViewHolder(holder: CalificacionAdapter.CalificarViewHolder, position: Int) {
        val envio = listaEnvios[position]
        with(holder.binding) {
            tvIdEnvio.text= "ID: ${envio.id}"
            tvRemitente.text = "Remitente: ${envio.nombreRemitente} ${envio.apellidoRemitente}"
            tvDestinatario.text = "Destinatario: ${envio.nombreDestinatario} ${envio.apellidoDestinatario}"
            tvDireccionOrigen.text = "Origen: ${envio.calleRemitente} ${envio.noRemitente}, ${envio.coloniaRemitente}, ${envio.estadoRemitente}"
            tvDireccionDestino.text = "Destino: ${envio.calleDestinatario} ${envio.noDestinatario}, ${envio.coloniaDestinatario}, ${envio.estadoDestinatario}"
            ratingBar.rating = envio.calificacion?.toFloat() ?: 0f
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

            putExtra("comentarios", envio.comentarios)
            putExtra("calificacion", envio.calificacion)

        }
        contexto.startActivity(intent)
    }
}