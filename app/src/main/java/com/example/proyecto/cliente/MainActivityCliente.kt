package com.example.proyecto.cliente

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.proyecto.R
import com.example.proyecto.SeleccionarTipoActivity
import com.example.proyecto.cliente.nav_fragments_cliente.FragmentInicioCliente
import com.example.proyecto.databinding.ActivityMainClienteBinding
import com.google.android.material.navigation.NavigationView

class MainActivityCliente : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    private lateinit var binding: ActivityMainClienteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        binding.navigationView.setNavigationItemSelectedListener(this)

        val toogle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        binding.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        replaceFragment(FragmentInicioCliente())

    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navFragment, fragment)
            .commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            /*R.id.op_inicio_cliente->{
                replaceFragment(FragmentInicioCliente())
            }*/
            R.id.op_cerrarSesion_cliente->{
                Toast.makeText(applicationContext, "Has cerrado sesión", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SeleccionarTipoActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}