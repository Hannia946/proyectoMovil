package com.example.proyecto.Repartidor

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Patterns
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto.R
import com.example.proyecto.databinding.ActivityRegistroRepartidorBinding
import org.intellij.lang.annotations.Pattern

class RegistroRepartidor : AppCompatActivity() {


    private lateinit var binding: ActivityRegistroRepartidorBinding

    //private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegistroRepartidorBinding.inflate(layoutInflater)
        setContentView(binding.root)



        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Espere por favor")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.btnRegistrarR.setOnClickListener {
            validarInformacion()
        }
    }

    private var nombresR = ""
    private var emailR = ""
    private var passwordR = ""
    private var Rpassword = ""

    private fun validarInformacion() {
        nombresR = binding.etNombresR.text.toString().trim()
        emailR = binding.etEmailR.text.toString().trim()
        passwordR = binding.etPasswordR.text.toString().trim()
        Rpassword = binding.etRPassword.text.toString().trim()

        if (nombresR.isEmpty()){
            binding.etNombresR.error = "Ingrese sus nombres"
            binding.etNombresR.requestFocus()

        }else if(emailR.isEmpty()){
            binding.etEmailR.error = "Ingrese email"
            binding.etEmailR.requestFocus()
        }else if (!Patterns.EMAIL_ADDRESS.matcher(emailR).matches()){
            binding.etEmailR.error = "Email no valido"
            binding.etEmailR.requestFocus()
        }else if (passwordR.isEmpty()){
            binding.etPasswordR.error = "Ingrese password"
            binding.etPasswordR.requestFocus()
        }else if (passwordR.length >=6){
            binding.etPasswordR.error = "Necesita 6 o mas car."
            binding.etPasswordR.requestFocus()
        }else if (Rpassword.isEmpty()) {
            binding.etRPassword.error = "Confirme password"
            binding.etRPassword.requestFocus()
        }else if (passwordR!=Rpassword){
            binding.etRPassword.error = "No coincide"
            binding.etRPassword.requestFocus()
        }else{
            registrarRepartidor()
        }

    }

    private fun registrarRepartidor() {


    }
}



