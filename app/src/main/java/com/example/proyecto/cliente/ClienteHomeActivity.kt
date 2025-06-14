package com.example.proyecto.cliente

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.R
import com.example.proyecto.Repartidor.nav_fragments_repartidor.FragmentInicioRepartidor
import com.example.proyecto.cliente.nav_fragments_cliente.FragmentInicioCliente

class ClienteHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente_home)

        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedorFragmentCliente, FragmentInicioCliente())
            .commit()

    }
}