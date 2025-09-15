package com.example.proyecto

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.cliente.DetalleEnvioActivity
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

            if(envio.entregado == false){
                btnEntregado.isVisible = false
                btnNoEntregado.isEnabled = true
                btnNoEntregado.isVisible = true
            }else if(envio.entregado == true){
                btnEntregado.isVisible = true
                btnEntregado.isEnabled = true
                btnNoEntregado.isVisible = false
            }else{
                btnEntregado.isVisible = false
                btnNoEntregado.isVisible = true
            }

            root.setOnClickListener{verEntrega(envio)}

            btnEntregado.setOnClickListener {
                actualizarEntrega2(envio)
                btnNoEntregado.isVisible = true
                btnEntregado.isVisible = false
            }

            btnNoEntregado.setOnClickListener {
                actualizarEntrega(envio)
                btnNoEntregado.isVisible = false
                btnEntregado.isVisible = true
            }

        }

    }
    private fun actualizarEntrega2(envio: Envio){
        //Toast.makeText(contexto, "Click en palomita", Toast.LENGTH_SHORT).show()

        val entregado = false
        val idEnvio = envio.id

        if(idEnvio != null){
            Datos.entregarEnvio(idEnvio, entregado)
        }

        AlertDialog.Builder(contexto)
            .setTitle("Tarea Pendiente")
            .setMessage("¡Pendiente de Entrega!")
            .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
            .show()

    }

    private fun actualizarEntrega(envio: Envio){
        //Toast.makeText(contexto, "Click en palomita", Toast.LENGTH_SHORT).show()

        val entregado = true
        val idEnvio = envio.id

        if(idEnvio != null){
            Datos.entregarEnvio(idEnvio, entregado)
        }

        AlertDialog.Builder(contexto)
            .setTitle("Tarea Completada")
            .setMessage("¡Completaste la entrega!")
            .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
            .show()

    }

    private fun verEntrega(envio: Envio){
        val intent = Intent(contexto, DetalleEnvioActivity::class.java).apply{

            putExtra("nombreRemitente", envio.nombreRemitente)
            putExtra("apellidoRemitente", envio.apellidoRemitente)

            putExtra("nombreDestinatario", envio.nombreDestinatario)
            putExtra("apellidoDestinatario", envio.apellidoDestinatario)

            putExtra("id", envio.id.toString())
            putExtra("calle", envio.calleRemitente)
            putExtra("no", envio.noRemitente)
            putExtra("colonia", envio.coloniaRemitente)
            putExtra("estado", envio.estadoRemitente)

            putExtra("calleD", envio.calleDestinatario)
            putExtra("noD", envio.noDestinatario)
            putExtra("coloniaD", envio.coloniaDestinatario)
            putExtra("estadoD", envio.estadoDestinatario)

            putExtra("descripcion", envio.descripcion)
            putExtra("piezas", envio.piezas)
            putExtra("peso", envio.peso)
            putExtra("alto", envio.Alto)
            putExtra("ancho", envio.Ancho)
            putExtra("largo", envio.Largo)

    }
        contexto.startActivity(intent)
    }

    override fun getItemCount(): Int = listaEnvios.size
}