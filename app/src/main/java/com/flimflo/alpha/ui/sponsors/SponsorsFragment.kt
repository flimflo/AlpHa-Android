package com.flimflo.alpha.ui.sponsors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.flimflo.alpha.R

class SponsorsFragment : Fragment() {

    private lateinit var sponsorsViewModel: SponsorsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sponsorsViewModel =
            ViewModelProviders.of(this).get(SponsorsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sponsors, container, false)
        val textView: TextView = root.findViewById(R.id.text_sponsors)
        sponsorsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

}