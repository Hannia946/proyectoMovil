package com.example.proyecto.Repartidor.nav_fragments_repartidor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.proyecto.R
import com.example.proyecto.databinding.FragmentInicioRepartidorBinding

class FragmentInicioRepartidor : Fragment() {

    private lateinit var binding: FragmentInicioRepartidorBinding
    private lateinit var mContext :Context

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflar el layout usando ViewBinding
        binding = FragmentInicioRepartidorBinding.inflate(inflater, container, false)


        binding.bottomNavigation.setOnItemSelectedListener{
            when(it.itemId){
                R.id.op_mispendientes_repartidor->{
                    replaceFragment(FragmentPendientes())
                }
                R.id.op_op_misnotificaciones_repartidor->{
                    replaceFragment(FragmentNotificar())

                }
            }
            true

        }
        replaceFragment(FragmentNotificar())
        binding.bottomNavigation.selectedItemId = R.id.op_op_misnotificaciones_repartidor

        binding.addFab.setOnClickListener{
            Toast.makeText(
                mContext,
                "Has presionado en boton flotante",
                Toast.LENGTH_SHORT
            ).show()

        }

        return binding.root
    }

    private fun replaceFragment(fragment: Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottom_fragment, fragment)
            .commit()

    }
}