package com.example.proyecto.Repartidor.nav_fragments_repartidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto.Datos
import com.example.proyecto.EnvioAdapter
import com.example.proyecto.R
import com.example.proyecto.TareaAdapter
import com.example.proyecto.databinding.FragmentHistorialEnviosClienteBinding
import com.example.proyecto.databinding.FragmentNotificarBinding

class FragmentNotificar : Fragment() {

    private var _binding: FragmentNotificarBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TareaAdapter(requireContext(), Datos.solicitudes)
        binding.recyclerHistorial.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerHistorial.adapter = adapter


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}