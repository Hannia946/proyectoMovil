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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPendientesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🚨 ¡ESTO FALTABA!
        binding.recyclerHistorial.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = TareaAdapter(requireContext(), Datos.solicitudes)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
