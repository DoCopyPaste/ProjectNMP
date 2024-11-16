package com.ubaya.projectnmp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.ubaya.projectnmp.databinding.FragmentWhoWeAreBinding

class WhoWeAreFragment : Fragment() {
    private lateinit var binding: FragmentWhoWeAreBinding
    private var likeCount = 0
    private val PREFS_NAME = "likePrefs"
    private val LIKE_KEY = "likeCount"
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // Handle any arguments if necessary
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWhoWeAreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize SharedPreferences
        prefs = requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Load the saved likeCount from SharedPreferences
        likeCount = prefs.getInt(LIKE_KEY, 0)

        // Set window insets and padding
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize likeButton text
        val likeButton = binding.likeButton
        likeButton.text = "($likeCount)"

        likeButton.setOnClickListener {
            likeCount++
            likeButton.text = "($likeCount)"

            // Save the updated likeCount to SharedPreferences
            with(prefs.edit()) {
                putInt(LIKE_KEY, likeCount)
                apply()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null!! // Avoid memory leaks
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WhoWeAreFragment().apply {
                arguments = Bundle().apply {
                    // Add arguments if needed
                }
            }
    }
}
