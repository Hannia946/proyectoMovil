package com.example.proyecto

class RepartidorR (
    nombre: String,
    apellido: String,
    telefono: String,
    email: String,
    password: String,
    var tipoUsuario: String = ""
) : Usuario(nombre, apellido, telefono, email, password)