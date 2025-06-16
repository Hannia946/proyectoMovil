package com.example.proyecto

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Datos {
    val solicitudes = mutableListOf<Envio>()
    private var lastId = 0

    // Guardar lista en SharedPreferences
    fun guardarSolicitudes(context: Context) {
        val prefs = context.getSharedPreferences("prefs_envios", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(solicitudes)
        editor.putString("lista_envios", json)
        editor.apply()

        Log.d("Datos", "Solicitudes guardadas, total: ${solicitudes.size}")
    }

    // Cargar lista desde SharedPreferences
    fun cargarSolicitudes(context: Context) {
        val prefs = context.getSharedPreferences("prefs_envios", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = prefs.getString("lista_envios", null)
        if (json != null) {
            val type = object : TypeToken<MutableList<Envio>>() {}.type
            val listaRecuperada: MutableList<Envio> = gson.fromJson(json, type)
            solicitudes.clear()
            solicitudes.addAll(listaRecuperada)
            lastId = solicitudes.maxOfOrNull { it.id } ?: 0
            Log.d("Datos", "Solicitudes cargadas: ${solicitudes.size}")
        } else {
            Log.d("Datos", "No hay solicitudes guardadas")
        }
    }

    // Agregar envío y guardar automáticamente
    fun agregarSolicitud(
        nombreRemitente: String,
        apellidoRemitente: String,
        telefonoRemitente: String,
        emailRemitente: String,
        calleRemitente: String,
        noRemitente: String,
        coloniaRemitente: String,
        estadoRemitente: String,
        codigoPostalRemitente: String,
        nombreDestinatario: String,
        apellidoDestinatario: String,
        telefonoDestinatario: String,
        emailDestinatario: String,
        calleDestinatario: String,
        noDestinatario: String,
        coloniaDestinatario: String,
        estadoDestinatario: String,
        codigoPostalDestinatario: String,
        descripcion: String,
        peso: String,
        piezas: String,
        Ancho: String,
        Largo: String,
        Alto: String,
        context: Context
    ) {
        solicitudes.add(
            Envio(
                id = ++lastId,
                nombreRemitente = nombreRemitente,
                apellidoRemitente = apellidoRemitente,
                telefonoRemitente = telefonoRemitente,
                emailRemitente = emailRemitente,
                calleRemitente = calleRemitente,
                noRemitente = noRemitente,
                coloniaRemitente = coloniaRemitente,
                estadoRemitente = estadoRemitente,
                codigoPostalRemitente = codigoPostalRemitente,
                nombreDestinatario = nombreDestinatario,
                apellidoDestinatario = apellidoDestinatario,
                telefonoDestinatario = telefonoDestinatario,
                emailDestinatario = emailDestinatario,
                calleDestinatario = calleDestinatario,
                noDestinatario = noDestinatario,
                coloniaDestinatario = coloniaDestinatario,
                estadoDestinatario = estadoDestinatario,
                codigoPostalDestinatario = codigoPostalDestinatario,
                descripcion = descripcion,
                peso = peso,
                piezas = piezas,
                Ancho = Ancho,
                Largo = Largo,
                Alto = Alto
            )
        )
        Log.d("Datos", "Solicitud agregada con id: $lastId")
        guardarSolicitudes(context)
    }

    fun calificarEnvio(id: Int, calificacion: Int, comentarios: String) {
        val envio = solicitudes.find { it.id == id }
        envio?.let {
            it.calificacion = calificacion
            it.comentarios = comentarios
        }
    }
}
