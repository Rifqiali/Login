package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    private lateinit var emailSignup: EditText
    private lateinit var passwordSignup: EditText
    private lateinit var confirmPasswordSignup: EditText
    private lateinit var btnSignup: Button
    private lateinit var loginRedirect: TextView

    // Dummy data (contoh pengguna yang sudah terdaftar)
    private val dummyEmail = "user@example.com"
    private val dummyPassword = "password123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        emailSignup = findViewById(R.id.emailSignup)
        passwordSignup = findViewById(R.id.passwordSignup)
        confirmPasswordSignup = findViewById(R.id.confirmPasswordSignup)
        btnSignup = findViewById(R.id.btnSignup)
        loginRedirect = findViewById(R.id.loginRedirect)

        btnSignup.setOnClickListener {
            val email = emailSignup.text.toString()
            val password = passwordSignup.text.toString()
            val confirmPassword = confirmPasswordSignup.text.toString()

            // Validasi sederhana
            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else if (email == dummyEmail) {
                // Cek apakah email sudah digunakan (dummy check)
                Toast.makeText(this, "Email is already registered", Toast.LENGTH_SHORT).show()
            } else {
                // Simulasi registrasi sukses
                Toast.makeText(this, "Signup Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        loginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
