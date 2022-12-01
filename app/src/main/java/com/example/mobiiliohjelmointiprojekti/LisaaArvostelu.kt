package com.example.mobiiliohjelmointiprojekti

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
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
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_lisaa_arvostelu, container, false)
        mArvosteluViewModel = ViewModelProvider(this)[ArvosteluViewModel::class.java]
        val btnArvosteluToDatabase = view.findViewById<Button>(R.id.btnArvosteluToDataBase)
        btnArvosteluToDatabase.setOnClickListener{
            insertToDatabase()
        }


    return view
    }

    private fun insertToDatabase(){
        val otsikko = headerLisaaArvostelu.toString();
        val teksti = multilineLisaaArvostelu.toString();
        val arvosana = arvosanaLisaaArvostelu;

        if(inputCheck(otsikko,teksti,arvosana)){
            val arvostelu = Arvostelu(0,otsikko,teksti,Integer.parseInt(arvosana.toString()))
            mArvosteluViewModel.addArvostelu(arvostelu)
            Toast.makeText(requireContext(),"Lisäys onnistui!",Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_lisaaArvostelu_to_arvosteluikkuna)
        }else{
            Toast.makeText(requireContext(),"Täytä kaikki kentät, Kiitos!",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(otsikko: String, teksti : String, arvosana : Int): Boolean{
        return !(TextUtils.isEmpty(otsikko) && TextUtils.isEmpty(teksti) && arvosana.equals(null))
    }
}