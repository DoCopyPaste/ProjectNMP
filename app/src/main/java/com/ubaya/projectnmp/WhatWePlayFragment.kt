package com.ubaya.projectnmp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.projectnmp.databinding.FragmentWhatWePlayBinding
import org.json.JSONObject



class WhatWePlayFragment : Fragment() {
    private lateinit var binding:FragmentWhatWePlayBinding
    var datas:ArrayList<WhatWePlayData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
//        val q = Volley.newRequestQueue(activity)
//        val url = "http://10.0.2.2/music/get_playlist.php"
//        var stringRequest = StringRequest(
//            Request.Method.POST, url,
//            {
//                Log.d("apiresult", it)
//                val obj = JSONObject(it)
//                if (obj.getString("result") == "OK") {
//                    val data = obj.getJSONArray("data")
//
//                    val sType = object : TypeToken<List<Playlist>>() { }.type
//                    playlists = Gson().fromJson(data.toString(), sType) as
//                            ArrayList<Playlist>
//                    Log.d("apiresult", playlists.toString())
//
//
//                    for (i in 0 until data.length()) {
//                        val playObj = data.getJSONObject(i)
//                        val playlist = Playlist(
//                            playObj.getInt("id"),
//                            playObj.getString("title"),
//                            playObj.getString("subtitle"),
//                            playObj.getString("description"),
//                            playObj.getString("image_url"),
//                            playObj.getInt("num_likes")
//                        )
//                        playlists.add(playlist)
//                    }
        //              UPDATE LIST
//                    Log.d("cekisiarray", playlists.toString())
//                }
//            },
//            {
//                Log.e("apiresult", it.message.toString())
//            })
//        q.add(stringRequest)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentWhatWePlayBinding.inflate(inflater,container,false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateList()
    }
    fun updateList() {
        val lm = LinearLayoutManager(activity)
        with(binding.recWhatWePlay) {
            layoutManager = lm
            setHasFixedSize(true)
            adapter = WhatWePlayAdapter()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WhatWePlayFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}