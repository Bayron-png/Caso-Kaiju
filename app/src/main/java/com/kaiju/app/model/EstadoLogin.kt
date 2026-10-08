package com.kaiju.app.model

data class EstadoLogin(
    val correo: String = "",
    val errorCorreo: String? = null,
    val contrasena: String = "",
    val errorContrasena: String? = null
)
