package com.example.mobiiliohjelmointiprojekti
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobiiliohjelmointiprojekti.R.id.*
import com.example.mobiiliohjelmointiprojekti.database.Arvostelu
import com.example.mobiiliohjelmointiprojekti.database.ArvosteluViewModel
import kotlinx.android.synthetic.main.fragment_lisaa_arvostelu.*
import kotlinx.android.synthetic.main.fragment_lisaa_arvostelu.view.*


class LisaaArvostelu : Fragment() {

    private lateinit var mArvosteluViewModel: ArvosteluViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_lisaa_arvostelu, container, false)
        mArvosteluViewModel = ViewModelProvider(this).get(ArvosteluViewModel::class.java)
        val otsikko = view.findViewById<EditText>(R.id.headerLisaaArvostelu)
        val arvostelu = view.findViewById<EditText>(R.id.multilineLisaaArvostelu)
        val numero = view.findViewById<EditText>(R.id.arvosanaLisaaArvostelu)

        view.btnArvosteluToDataBase.setOnClickListener{
            insertToDatabase()
        }
        arvostelu.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(v)
            }
        }
        otsikko.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(v)
            }
        }
        numero.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(v)
            }
        }

        return view

    }

    private fun insertToDatabase(){
        val otsikko = headerLisaaArvostelu.text.toString();
        val teksti = multilineLisaaArvostelu.text.toString();
        val arvosana = arvosanaLisaaArvostelu.text;

        if(inputCheck(otsikko,teksti,arvosana)){
            val arvostelu = Arvostelu(0,otsikko,teksti,Integer.parseInt(arvosana.toString()))
            mArvosteluViewModel.addArvostelu(arvostelu)
            Toast.makeText(requireContext(),"Lisäys onnistui!",Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_lisaaArvostelu_to_arvosteluikkuna)
        }else{
            Toast.makeText(requireContext(),"Täytä kaikki kentät, Kiitos!",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(otsikko: String, teksti : String, arvosana : Editable): Boolean{
        return !(TextUtils.isEmpty(otsikko) && TextUtils.isEmpty(teksti) && arvosana.isEmpty())
    }

   private fun hideKeyboard(view: View){
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }




}