package com.ubaya.projectnmp

import android.R
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class WhatWePlayFragmentList : ListFragment() {
    private var events: ArrayList<com.ubaya.projectnmp.WhatWePlayBank> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            events = it.getParcelableArrayList<com.ubaya.projectnmp.WhatWePlayBank>(com.ubaya.projectnmp.ARG_EVENTS) as ArrayList<com.ubaya.projectnmp.WhatWePlayBank>
            listAdapter = ArrayAdapter(
                requireContext(),
                R.layout.simple_list_item_1, events
            )
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var detailFragment =
            com.ubaya.projectnmp.WhatWePlayData.newInstance(events[position])
        activity?.supportFragmentManager?.beginTransaction()?.let {
            detailFragment.show(it, "dialog")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(exts: ArrayList<com.ubaya.projectnmp.WhatWePlayBank>) =
            WhatWePlayFragmentList().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_EVENTS, exts)
                }
            }
    }
}