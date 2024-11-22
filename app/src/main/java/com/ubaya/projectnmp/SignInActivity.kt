package com.ubaya.projectnmp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.projectnmp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            val username = binding.usernameField.text.toString()
            val password = binding.passwordField.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (validateCredentials(username, password)) {
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    navigateToMainActivity()
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        // Ambil data dari SharedPreferences
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val storedUsername = sharedPreferences.getString("username", null)
        val storedPassword = sharedPreferences.getString("password", null)

        return username == storedUsername && password == storedPassword
    }

    private fun navigateToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
