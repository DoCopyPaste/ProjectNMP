package com.ubaya.projectnmp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.projectnmp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    // Simulasi daftar username
    private val existingUsers = mutableListOf("user1", "user2", "admin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.firstNameField.addTextChangedListener(textWatcher)
        binding.lastNameField.addTextChangedListener(textWatcher)
        binding.usernameNameField.addTextChangedListener(textWatcher)
        binding.passwordField.addTextChangedListener(textWatcher)
        binding.repeatPasswordField.addTextChangedListener(textWatcher)
//        binding.termsCheckBox.setOnCheckedChangeListener { _, _ ->
//            validateForm()
//        }

        binding.submitButton.setOnClickListener {
            val validationErrors = checkValidationErrors()

            if (validationErrors.isEmpty()) {
                // Jika validasi berhasil, simpan data dan pindah ke SignIn
                saveUserData()
                Toast.makeText(this, "Account successfully created!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finish() // Tutup halaman signup
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

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            validateForm()
        }

        override fun afterTextChanged(s: Editable?) {}
    }

    private fun validateForm() {
        val isTermsChecked = binding.termsCheckBox.isChecked
        binding.submitButton.isEnabled = isTermsChecked
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
        } else if (lastName.isEmpty()) {
            errors.add("Last Name is required.")
        }
        else if (username.isEmpty()) {
            errors.add("Username is required.")
        } else if (!isUsernameUnique(username)) {
            errors.add("Username is already taken.")
        }
        else if (password.isEmpty()) errors.add("Password is required.")
        else if (repeatPassword.isEmpty()) errors.add("Repeat Password is required.")
        else if (password != repeatPassword) errors.add("Password and Repeat Password must match.")
        else if (!binding.termsCheckBox.isChecked) errors.add("You must agree to the terms and conditions.")

        return errors
    }

    private fun isUsernameUnique(username: String): Boolean {
        return !existingUsers.contains(username)
    }

    private fun saveUserData() {
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val username = binding.usernameNameField.text.toString().trim()
        val password = binding.passwordField.text.toString()

        // Simpan username dan password ke SharedPreferences
        with(sharedPreferences.edit()) {
            putString("username", username)
            putString("password", password)
            apply()
        }
    }
}
