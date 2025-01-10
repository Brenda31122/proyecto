package com.example.jlcarlitos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias de los elementos
        val btnEnter: Button = findViewById(R.id.btnEnter)
        val txtEmail: TextView = findViewById(R.id.edtEmail)
        val txtPassword: TextView = findViewById(R.id.edtPassword)

        // Inicialización de Firebase Auth
        firebaseAuth = Firebase.auth

        btnEnter.setOnClickListener {
            val email = txtEmail.text.toString().trim()
            val password = txtPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                signIn(email, password)
            } else {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signIn(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Toast.makeText(this, "Bienvenido: ${user?.email}", Toast.LENGTH_SHORT).show()

                    // Redirigir a LoginActivity
                    val intent = Intent(this, login::class.java)
                    startActivity(intent)
                    finish() // Opcional: Finalizar la actividad actual para que no se pueda volver con "atrás"
                } else {
                    val error = task.exception?.message ?: "Error desconocido"
                    Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
