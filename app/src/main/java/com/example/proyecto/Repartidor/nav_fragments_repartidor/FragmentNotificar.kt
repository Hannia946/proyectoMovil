package com.example.proyecto.Repartidor.nav_fragments_repartidor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.proyecto.Envio
import com.example.proyecto.R

class FragmentNotificar : Fragment() {

    private var envio: Envio? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        envio = arguments?.getSerializable("envio") as? Envio
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notificar, container, false)

        // Referencias a los TextViews en el layout
        val tvIdEnvio = view.findViewById<TextView>(R.id.tvIdEnvio)
        val tvRemitente = view.findViewById<TextView>(R.id.tvRemitente)
        val tvDestinatario = view.findViewById<TextView>(R.id.tvDestinatario)
        val tvDireccionOrigen = view.findViewById<TextView>(R.id.tvDireccionOrigen)
        val tvDireccionDestino = view.findViewById<TextView>(R.id.tvDireccionDestino)

        // Mostrar la info del envio si no es null
        envio?.let { e ->
            tvIdEnvio.text = "ID: ${e.id}"
            tvRemitente.text = "Remitente: ${e.nombreRemitente} ${e.apellidoRemitente}"
            tvDestinatario.text = "Destinatario: ${e.nombreDestinatario} ${e.apellidoDestinatario}"
            tvDireccionOrigen.text = "Origen: ${e.calleRemitente} ${e.noRemitente}, ${e.coloniaRemitente}, ${e.estadoRemitente}"
            tvDireccionDestino.text = "Destino: ${e.calleDestinatario} ${e.noDestinatario}, ${e.coloniaDestinatario}, ${e.estadoDestinatario}"
        }

        return view
    }

    companion object {
        fun newInstance(envio: Envio): FragmentNotificar {
            val fragment = FragmentNotificar()
            val bundle = Bundle()
            bundle.putSerializable("envio", envio)
            fragment.arguments = bundle
            return fragment
        }
    }
}
