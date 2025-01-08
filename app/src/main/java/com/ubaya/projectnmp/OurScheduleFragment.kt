package com.ubaya.projectnmp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.projectnmp.databinding.FragmentOurScheduleBinding
import com.ubaya.projectnmp.databinding.FragmentWhatWePlayBinding



class OurScheduleFragment : Fragment() {
    private lateinit var binding:FragmentOurScheduleBinding
    var datas:ArrayList<OurScheduleData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        
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
            adapter = OurScheduleAdapter()
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