package com.ubaya.projectnmp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.projectnmp.databinding.ActivitySignUpBinding
import org.json.JSONObject

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestQueue = Volley.newRequestQueue(this)

        setupListeners()
    }

    private fun setupListeners() {
        binding.firstNameField.addTextChangedListener(textWatcher)
        binding.lastNameField.addTextChangedListener(textWatcher)
        binding.usernameNameField.addTextChangedListener(textWatcher)
        binding.passwordField.addTextChangedListener(textWatcher)
        binding.repeatPasswordField.addTextChangedListener(textWatcher)

        binding.submitButton.setOnClickListener {
            val validationErrors = checkValidationErrors()

            if (validationErrors.isEmpty()) {
                // Jika validasi berhasil, kirim data ke server
                signUpUser()
            } else {
                // Jika ada error, tampilkan pesan
                Toast.makeText(this, validationErrors.joinToString("\n"), Toast.LENGTH_SHORT).show()
            }
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {}
    }

    private fun checkValidationErrors(): List<String> {
        val errors = mutableListOf<String>()

        val firstName = binding.firstNameField.text.toString().trim()
        val lastName = binding.lastNameField.text.toString().trim()
        val username = binding.usernameNameField.text.toString().trim()
        val password = binding.passwordField.text.toString()
        val repeatPassword = binding.repeatPasswordField.text.toString()

        if (firstName.isEmpty()) {
            errors.add("First Name is required.")
        }
        if (lastName.isEmpty()) {
            errors.add("Last Name is required.")
        }
        if (username.isEmpty()) {
            errors.add("Username is required.")
        }
        if (password.isEmpty()) {
            errors.add("Password is required.")
        }
        if (repeatPassword.isEmpty()) {
            errors.add("Repeat Password is required.")
        }
        if (password != repeatPassword) {
            errors.add("Password and Repeat Password must match.")
        }
        if (!binding.termsCheckBox.isChecked) {
            errors.add("You must agree to the terms and conditions.")
        }

        return errors
    }

    private fun signUpUser() {
        val firstName = binding.firstNameField.text.toString().trim()
        val lastName = binding.lastNameField.text.toString().trim()
        val username = binding.usernameNameField.text.toString().trim()
        val password = binding.passwordField.text.toString()

        // Kirim data ke server
        val url = "https://ubaya.xyz/native/160422011/signup.php" // Ganti dengan URL API Anda

        val stringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                val jsonResponse = JSONObject(response)
                val status = jsonResponse.getString("status")
                val message = jsonResponse.getString("message")

                if (status == "OK") {
                    Toast.makeText(this, "Account successfully created!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, SignInActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["first_name"] = firstName
                params["last_name"] = lastName
                params["username"] = username
                params["password"] = password
                return params
            }
        }

        requestQueue.add(stringRequest)
    }
}
