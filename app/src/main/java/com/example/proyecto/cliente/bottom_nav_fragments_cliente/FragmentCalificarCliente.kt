package com.example.proyecto.cliente.bottom_nav_fragments_cliente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto.Datos
import com.example.proyecto.EnvioAdapter
import com.example.proyecto.cliente.CalificacionAdapter
import com.example.proyecto.databinding.FragmentCalificarClienteBinding



class FragmentCalificarCliente: Fragment()  {
    private lateinit var adapter: CalificacionAdapter

    private var _binding: FragmentCalificarClienteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalificarClienteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerHistorial.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerHistorial.adapter = CalificacionAdapter(requireContext(), Datos.solicitudes)



    }

    override fun onResume() {
        super.onResume()
        binding.recyclerHistorial.adapter?.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


