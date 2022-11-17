package com.example.mobiiliohjelmointiprojekti

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mobiiliohjelmointiprojekti.R.id.*
import com.example.mobiiliohjelmointiprojekti.database.Arvostelu
import com.example.mobiiliohjelmointiprojekti.database.ArvosteluViewModel


class LisaaArvostelu : Fragment() {


    private lateinit var mArvosteluViewModel: ArvosteluViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lisaa_arvostelu, container, false)

        mArvosteluViewModel = ViewModelProvider(this).get(ArvosteluViewModel::class.java)
        val btnlahetaArvostelu = view.findViewById<Button>(btnLahetaArvostelu)
        btnlahetaArvostelu.setOnClickListener{
            insertDataToDatabase()
        }
        //Koodia
        return view


    }

    private fun insertDataToDatabase() {
        val otsikko = addArvosteluHeader.toString()
        val arvosteluteksti = addArvostelu.toString()
        val arvosana = addArvosana

        if(inputCheck(otsikko,arvosteluteksti,arvosana)){
            val arvostelu = Arvostelu(0,otsikko,arvosteluteksti, Integer.parseInt(arvosana.toString()))
            mArvosteluViewModel.addArvostelu(arvostelu)
            Toast.makeText(requireContext(),"Lisääminen onnistui", Toast.LENGTH_LONG)
            findNavController().navigate(R.id.action_lisaaArvostelu_to_arvosteluikkuna)
        }
    }
    private fun inputCheck(otsikko: String, arvosteluteksti: String, arvosana: Int):Boolean{
        return !(TextUtils.isEmpty(otsikko) && TextUtils.isEmpty(arvosteluteksti) && arvosana.equals(null))
    }

}