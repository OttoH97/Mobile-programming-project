package com.example.mobiiliohjelmointiprojekti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_katso_arvostelua.view.*


class KatsoArvostelua : Fragment() {

private val args by navArgs<ArvosteluikkunaArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_katso_arvostelua, container,false)

        view.katsoArvosteluHeader.text = args.currentArvostelu.otsikko
        view.katsoArvosteluTeksti.setText(args.currentArvostelu.teksti)
        view.katsoArvosteluNumero.text = args.currentArvostelu.arvosana.toString()

        /*view.btnToArvosteluIkkuna.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_katsoArvostelua_to_arvosteluikkuna)
        }*/

        return view
    }

}