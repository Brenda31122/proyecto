package com.example.jlcarlitos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter: Button = findViewById(R.id.btnEnter)
        val txtemail : TextView = findViewById(R.id.edtEmail)
        val txtpassword : TextView = findViewById(R.id.edtPassword)
        btnEnter.setOnClickListener()
        {

        }
    }
    private fun signIn(email:String, password: String)
    {
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener(this){ task ->
                if (task.isSuccessful){
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext, "Error de email o contraseña",Toast.LENGTH_SHORT).show()
                    //a qui vamos a ir a la segunda activity
                }
                else

            }

        )
    }
}