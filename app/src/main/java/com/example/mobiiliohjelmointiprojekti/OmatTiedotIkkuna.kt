package com.example.mobiiliohjelmointiprojekti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_omat_tiedot_ikkuna.view.*

class OmatTiedotIkkuna : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_omat_tiedot_ikkuna, container, false)

        view.btnSwitch.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        view.btnLogOut.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_omatTiedot_to_paa)
        }

        return view
    }



}