package com.example.proyecto.Repartidor.nav_fragments_repartidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto.Datos
import com.example.proyecto.TareaAdapter
import com.example.proyecto.databinding.FragmentPendientesBinding

class FragmentPendientes : Fragment() {

    private var _binding: FragmentPendientesBinding? = null
    private val binding get() = _binding!!

    private lateinit var tareaAdapter: TareaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPendientesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar layout manager una sola vez
        binding.recyclerPendientes.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        Datos.cargarSolicitudes(requireContext())  // Carga los datos guardados
        val adapter = TareaAdapter(requireContext(), Datos.solicitudes)
        binding.recyclerPendientes.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
