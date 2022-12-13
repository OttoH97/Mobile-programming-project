package com.example.mobiiliohjelmointiprojekti.register

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobiiliohjelmointiprojekti.R
import com.example.mobiiliohjelmointiprojekti.database.Kayttaja
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        Log.i("RegisterFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        view.btnRegister.setOnClickListener {
            insertToDatabase()
        }

        return view
    }

    private fun insertToDatabase(){
        val tunnus = editTextUsernameR.text.toString()
        val salasana = editTextPasswordR.text.toString()

        if (inputCheck(tunnus, salasana)){
            val kayttaja = Kayttaja(0, tunnus, salasana)
            viewModel.addKayttaja(kayttaja)
            Toast.makeText(requireContext(),"Rekisteröinti onnistui!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_register_to_omatTiedot)
        }else{
            Toast.makeText(requireContext(),"Täytä kaikki kentät, kiitos!",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(tunnus: String, salasana : String): Boolean{
        return !(TextUtils.isEmpty(tunnus) || TextUtils.isEmpty(salasana))
    }

}