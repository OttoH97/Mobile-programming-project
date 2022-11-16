@file:Suppress("DEPRECATION")

package com.example.mobiiliohjelmointiprojekti

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class Paaikkuna : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_paaikkuna, container, false)

        //Navigointi Pääikkunasta
        val btnOmatSivut = view.findViewById<Button>(R.id.btnOmatSivut)
        val btnArvostelut = view.findViewById<Button>(R.id.btnArvostelut)

        btnOmatSivut.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_paa_to_omatTiedot)
        }

        btnArvostelut.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_paa_to_arvostelu)
        }

        return view
    }

}