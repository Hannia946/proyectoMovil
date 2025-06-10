package com.example.proyecto.cliente.nav_fragments_cliente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto.R
import com.example.proyecto.cliente.bottom_nav_fragments_cliente.FragmentHistorialEnviosCliente
import com.example.proyecto.databinding.FragmentInicioClienteBinding

class FragmentInicioCliente : Fragment() {
    private lateinit var binding: FragmentInicioClienteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInicioClienteBinding.inflate(inflater, container, false)
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.op_registro_cliente->{

                }
                R.id.op_historial_cliente->{

                }
                R.id.op_calificar_cliente->{

                }
            }
            true
        }
        replaceFragment(FragmentHistorialEnviosCliente())
        binding.bottomNavigation.selectedItemId = R.id.op_historial_cliente
        return binding.root

    }

    private fun replaceFragment(fragment: Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottom_fragment, fragment)
            .commit()

    }



}