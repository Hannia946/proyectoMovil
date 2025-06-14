import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.proyecto.R
import com.example.proyecto.Repartidor.nav_fragments_repartidor.FragmentInicioRepartidor
import com.example.proyecto.cliente.nav_fragments_cliente.FragmentInicioCliente
import com.example.proyecto.databinding.ActivityMainRepartidorBinding
import com.google.android.material.navigation.NavigationView

class MainActivityRepartidor : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainRepartidorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainRepartidorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        binding.navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        replaceFragment(FragmentInicioRepartidor())
        binding.navigationView.setCheckedItem(R.id.op_inicio_repartidor)


    }















    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.op_inicio_repartidor -> {

                replaceFragment(FragmentInicioRepartidor())
            }

            R.id.op_cerrarSesion_repartidor -> {
                Toast.makeText(this, "Has cerrado sesión", Toast.LENGTH_SHORT).show()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragmentInicioRepartidor: FragmentInicioRepartidor) {

    }

}
