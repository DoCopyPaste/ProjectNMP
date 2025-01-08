package com.ubaya.projectnmp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.projectnmp.databinding.FragmentOurScheduleBinding
import com.ubaya.projectnmp.databinding.FragmentWhatWePlayBinding
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class OurScheduleFragment : Fragment() {
    private lateinit var binding:FragmentOurScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }

    // Fungsi untuk parsing tanggal dan waktu dari string
    fun parseDate(dateString: String): java.sql.Date {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)  // Format tanggal dengan jam
        val utilDate = format.parse(dateString)  // Menghasilkan java.util.Date
        return java.sql.Date(utilDate.time)  // Konversi ke java.sql.Date
    }

    private fun fetchEvents() {
        val url = "https://ubaya.xyz/native/160422011/get_events.php" // Ganti dengan URL API 1

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                try {
                    val jsonResponse = JSONObject(response)
                    val status = jsonResponse.getString("status")

                    if (status == "OK") {
                        val eventsArray = jsonResponse.getJSONArray("events")
                        val eventsList = mutableListOf<Event>()

                        for (i in 0 until eventsArray.length()) {
                            val eventObj = eventsArray.getJSONObject(i)
                            val event = Event(
                                game = eventObj.getString("game"),
                                description = eventObj.getString("description"),
                                schedule = parseDate(eventObj.getString("date")),
                                title = eventObj.getString("name"),
                                team = eventObj.getString("team"),
                                imageId = eventObj.getInt("idgame")
                            )
//                            Log.d("date", eventObj.getString("date"))
                            eventsList.add(event)
                        }
                        binding.recOurSchedule.adapter = OurScheduleAdapter(eventsList)
                    } else {
                        Toast.makeText(requireContext(), "Failed to fetch events", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(requireContext(), "Error parsing events", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(requireContext(), "Error fetching events: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )

        Volley.newRequestQueue(requireContext()).add(stringRequest)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOurScheduleBinding.inflate(inflater,container,false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateList()
    }

    fun updateList() {
        val lm = LinearLayoutManager(activity)
        with(binding.recOurSchedule) {
            layoutManager = lm
            setHasFixedSize(true)
            fetchEvents()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OurScheduleFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}