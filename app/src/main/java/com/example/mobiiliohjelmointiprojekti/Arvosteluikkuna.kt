package com.example.mobiiliohjelmointiprojekti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.mobiiliohjelmointiprojekti.database.ArvosteluViewModel
import com.example.mobiiliohjelmointiprojekti.database.UserViewModel

class Arvosteluikkuna : Fragment() {

    private lateinit var mArvosteluViewModel: ArvosteluViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_arvosteluikkuna, container, false)


        //Koodia
        return view


    }




}