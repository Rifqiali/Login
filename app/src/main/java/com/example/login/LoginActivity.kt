package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailLogin: EditText
    private lateinit var passwordLogin: EditText
    private lateinit var btnLogin: Button
    private lateinit var signupRedirect: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailLogin = findViewById(R.id.emailLogin)
        passwordLogin = findViewById(R.id.passwordLogin)
        btnLogin = findViewById(R.id.btnLogin)
        signupRedirect = findViewById(R.id.signupRedirect)

        // Dummy data
        val dummyEmail = "user@example.com"
        val dummyPassword = "password123"

        btnLogin.setOnClickListener {
            val email = emailLogin.text.toString()
            val password = passwordLogin.text.toString()

            // Validasi sederhana (Email dan password tidak boleh kosong)
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else if (email == dummyEmail && password == dummyPassword) {
                // Verifikasi dummy login
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
            } else {
                // Jika email atau password tidak cocok
                Toast.makeText(this, "Login Failed: Incorrect email or password", Toast.LENGTH_SHORT).show()
            }
        }

        signupRedirect.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
