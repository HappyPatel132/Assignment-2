// InfoFragment.kt
package com.example.simpleinfoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        val radioButtonOption1: RadioButton = view.findViewById(R.id.radioButtonOption1)
        val radioButtonOption2: RadioButton = view.findViewById(R.id.radioButtonOption2)
        val spinner: Spinner = view.findViewById(R.id.spinnerOptions)
// InfoFragment.kt (Add in onCreateView method)
        val spinnerOptions = resources.getStringArray(R.array.spinner_options)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, spinnerOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        radioButtonOption1.setOnClickListener {
            Toast.makeText(activity, "Option 1 Selected", Toast.LENGTH_SHORT).show()
        }

        radioButtonOption2.setOnClickListener {
            Toast.makeText(activity, "Option 2 Selected", Toast.LENGTH_SHORT).show()
        }


        return view
    }
}
