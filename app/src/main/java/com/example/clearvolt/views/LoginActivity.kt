package com.example.clearvolt.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clearvolt.R
import com.example.clearvolt.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val authenticate by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {
            loginUser()
        }

    }

    override fun onStart() {
        super.onStart()
        verifyUserAuth()
    }

    private fun loginUser() {
        val email = binding.editTextEmail.text.toString()
        val senha = binding.editTextSenha.text.toString()

        authenticate.signInWithEmailAndPassword(email,senha)
            .addOnSuccessListener { authResult ->
                verifyUserAuth()
            }
            .addOnFailureListener{ exeption ->
                AlertDialog.Builder(this)
                    .setTitle("Erro ao entrar")
                    .setMessage("Email e/ou senha incorretos")
                    .setPositiveButton("OK"){dialog,posicao->

                    }
                    .create().show()
            }
    }

    private fun verifyUserAuth() {
        val user = authenticate.currentUser
        if (user != null){
            startActivity(Intent(this, NavigationActivity::class.java))
        }
    }
}