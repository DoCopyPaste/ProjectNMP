package com.ubaya.projectnmp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.projectnmp.databinding.ActivitySignInBinding
import org.json.JSONObject

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        // Check if user is already logged in
        if (sharedPreferences.getBoolean("logged_in", true)) {
            navigateToMainActivity()
        }

        binding.submitButton.setOnClickListener {
            val username = binding.usernameField.text.toString()
            val password = binding.passwordField.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                validateCredentials(username, password)
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun validateCredentials(username: String, password: String) {
//        // Ambil data dari SharedPreferences
//        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
//        val storedUsername = sharedPreferences.getString("username", null)
//        val storedPassword = sharedPreferences.getString("password", null)
//
//        return username == storedUsername && password == storedPassword

        val url = "https://ubaya.xyz/native/160422011/validate_login.php" // Sesuaikan URL dengan endpoint server Anda
        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            { response ->
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.getString("status") == "OK") {
                        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                        val userId = jsonObject.getString("user_id")
                        val username = jsonObject.getString("username")
                        saveSession(userId, username)
                        navigateToMainActivity()
                    } else {
                        Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, "Error parsing response: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["username"] = username
                params["password"] = password
                return params
            }
        }

        queue.add(stringRequest)
    }

    private fun saveSession(userId: String, username: String) {
        with(sharedPreferences.edit()) {
            putBoolean("logged_in", true)
            putString("user_id", userId)
            putString("username", username)
            apply()
        }
    }

    private fun navigateToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
