package com.ubaya.projectnmp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var usernameField: EditText
    private lateinit var passwordField: EditText
    private lateinit var submitButton: Button
    private lateinit var signUpButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        // Check if user is already logged in
        if (sharedPreferences.getBoolean("logged_in", false)) {
            navigateToMainActivity()
        }

        usernameField = findViewById(R.id.usernameField)
        passwordField = findViewById(R.id.passwordField)
        submitButton = findViewById(R.id.submitButton)
        signUpButton = findViewById(R.id.signUpButton)

        submitButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (validateCredentials(username, password)) {
                    saveSession()
                    navigateToMainActivity()
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }

        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        // Replace with actual authentication logic
        return username == "admin" && password == "password"
    }

    private fun saveSession() {
        with(sharedPreferences.edit()) {
            putBoolean("logged_in", true)
            apply()
        }
    }

    private fun navigateToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
