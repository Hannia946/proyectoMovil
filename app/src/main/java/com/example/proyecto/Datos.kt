package com.example.proyecto

object Datos {
    val solicitudes = mutableListOf<Envio>()
    private var lastId = 0

    fun agregarSolicitud(nombreRemitente: String,
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
                         Alto: String) {
        solicitudes.add(
            Envio(
                id = ++lastId,
                nombreRemitente = nombreRemitente ,
                apellidoRemitente = apellidoRemitente,
                telefonoRemitente = telefonoRemitente,
                emailRemitente = emailRemitente,
                calleRemitente = calleRemitente,
                noRemitente = noRemitente,
                coloniaRemitente = coloniaRemitente,
                estadoRemitente = estadoRemitente,
                codigoPostalRemitente = codigoPostalRemitente,
                nombreDestinatario   = nombreDestinatario,
                apellidoDestinatario = apellidoDestinatario,
                telefonoDestinatario = telefonoDestinatario,
                emailDestinatario = emailDestinatario ,
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
    }
}