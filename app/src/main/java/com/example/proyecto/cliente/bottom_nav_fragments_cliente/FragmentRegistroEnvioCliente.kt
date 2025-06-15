package com.example.proyecto.cliente.bottom_nav_fragments_cliente

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.proyecto.Datos
import com.example.proyecto.R
import com.example.proyecto.databinding.FragmentRegistroEnvioClienteBinding
import android.os.Handler
import android.os.Looper

class FragmentRegistroEnvioCliente : Fragment() {

    private var _binding: FragmentRegistroEnvioClienteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistroEnvioClienteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterPeso = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.opciones_peso,
            android.R.layout.simple_spinner_item
        )
        adapterPeso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.SpinnerPeso.adapter = adapterPeso

        val adapterPiezas = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.opciones_piezas,
            android.R.layout.simple_spinner_item
        )
        adapterPiezas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.SpinnerQtyPzas.adapter = adapterPiezas

        binding.btnRegistrarEnvio.setOnClickListener {
            val rNombre = binding.etNombreCompletoR.text.toString()
            val rApellido = binding.etApellidosR.text.toString()
            val rTel = binding.etTelefonoR.text.toString()
            val rEmail = binding.etEmailR.text.toString()
            val rCalle = binding.etCalleR.text.toString()
            val rNo = binding.etNoCasaR.text.toString()
            val rColonia = binding.etColoniaR.text.toString()
            val rEstado = binding.etEstadoR.text.toString()
            val rCP = binding.etCodigoPostalR.text.toString()

            val dNombre = binding.etNombreCompletoD.text.toString()
            val dApellido = binding.etApellidoD.text.toString()
            val dTel = binding.etTelefonoD.text.toString()
            val dEmail = binding.etEmailD.text.toString()
            val dCalle = binding.etCalleD.text.toString()
            val dNo = binding.etNoCasaD.text.toString()
            val dColonia = binding.etColoniaD.text.toString()
            val dEstado = binding.etEstadoD.text.toString()
            val dCP = binding.etCodigoPostalD.text.toString()

            val descripcion = binding.etDescripcion.text.toString()
            val peso = binding.SpinnerPeso.selectedItem.toString()
            val piezas = binding.SpinnerQtyPzas.selectedItem.toString()
            val ancho = binding.etAncho.text.toString()
            val largo = binding.etLargo.text.toString()
            val alto = binding.etAlto.text.toString()

            if (rNombre.isBlank() || dNombre.isBlank() || descripcion.isBlank()) {
                AlertDialog.Builder(requireContext())
                    .setTitle("Campos Incompletos")
                    .setMessage("Llena todos los campos obligatorios")
                    .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
                    .show()
                return@setOnClickListener
            }

            // Mostrar ProgressBar
            binding.progressBar.visibility = View.VISIBLE
            binding.btnRegistrarEnvio.isEnabled = false

            // Simular tiempo de procesamiento
            Handler(Looper.getMainLooper()).postDelayed({
                Datos.agregarSolicitud(
                    rNombre, rApellido, rTel, rEmail, rCalle, rNo, rColonia, rEstado, rCP,
                    dNombre, dApellido, dTel, dEmail, dCalle, dNo, dColonia, dEstado, dCP,
                    descripcion, peso, piezas, ancho, largo, alto
                )

                // Ocultar ProgressBar
                binding.progressBar.visibility = View.GONE
                binding.btnRegistrarEnvio.isEnabled = true

                AlertDialog.Builder(requireContext())
                    .setTitle("Solicitud de envío")
                    .setMessage("Solicitud enviada correctamente")
                    .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
                    .show()

                // Limpiar campos
                limpiarCampos()

            }, 1500) // 1.5 segundos

        }
    }

    private fun limpiarCampos() {
        with(binding) {
            etNombreCompletoR.setText("")
            etApellidosR.setText("")
            etTelefonoR.setText("")
            etEmailR.setText("")
            etCalleR.setText("")
            etNoCasaR.setText("")
            etColoniaR.setText("")
            etEstadoR.setText("")
            etCodigoPostalR.setText("")

            etNombreCompletoD.setText("")
            etApellidoD.setText("")
            etTelefonoD.setText("")
            etEmailD.setText("")
            etCalleD.setText("")
            etNoCasaD.setText("")
            etColoniaD.setText("")
            etEstadoD.setText("")
            etCodigoPostalD.setText("")

            etDescripcion.setText("")
            etAncho.setText("")
            etLargo.setText("")
            etAlto.setText("")

            SpinnerPeso.setSelection(0)
            SpinnerQtyPzas.setSelection(0)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}