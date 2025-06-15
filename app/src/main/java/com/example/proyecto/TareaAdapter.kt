package com.example.proyecto

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.cliente.CalificacionEnvioActivity
import com.example.proyecto.databinding.ItemTareaBinding

class TareaAdapter(
    private val contexto: Context,
    private val listaEnvios: MutableList<Envio>
) : RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {

    inner class TareaViewHolder(val binding: ItemTareaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val binding = ItemTareaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TareaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val envio = listaEnvios[position]

        with(holder.binding) {
            // Mostrar información del envío
            tvIdEnvioT.text = "ID: ${envio.id}"
            tvRemitente.text = "Remitente: ${envio.nombreRemitente} ${envio.apellidoRemitente}"
            tvDestinatario.text = "Destinatario: ${envio.nombreDestinatario} ${envio.apellidoDestinatario}"
            tvDireccionOrigen.text = "Origen: ${envio.calleRemitente} ${envio.noRemitente}, ${envio.coloniaRemitente}, ${envio.estadoRemitente}"
            tvDireccionDestino.text = "Destino: ${envio.calleDestinatario} ${envio.noDestinatario}, ${envio.coloniaDestinatario}, ${envio.estadoDestinatario}"

            // Resetear estado por si se recicla la vista
            btnEntregado.isEnabled = true
            btnNoEntregado.isEnabled = true

            btnEntregado.setOnClickListener {
                Toast.makeText(contexto, "Click en palomita", Toast.LENGTH_SHORT).show()

                val intent = Intent(contexto, CalificacionEnvioActivity::class.java)
                intent.putExtra("idEnvio", envio.id)
                contexto.startActivity(intent)

                btnEntregado.isEnabled = false
                btnNoEntregado.isEnabled = true
            }

            btnNoEntregado.setOnClickListener {
                Toast.makeText(contexto, "El envío no fue entregado", Toast.LENGTH_SHORT).show()

                btnNoEntregado.isEnabled = false
                btnEntregado.isEnabled = true
            }
        }
    }

    override fun getItemCount(): Int = listaEnvios.size
}
