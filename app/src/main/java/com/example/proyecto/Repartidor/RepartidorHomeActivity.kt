package com.example.proyecto.Repartidor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.R
import com.example.proyecto.Repartidor.nav_fragments_repartidor.FragmentInicioRepartidor

class RepartidorHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repartidor_home)

        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedorFragmentRepartidor, FragmentInicioRepartidor())
            .commit()
    }
}
