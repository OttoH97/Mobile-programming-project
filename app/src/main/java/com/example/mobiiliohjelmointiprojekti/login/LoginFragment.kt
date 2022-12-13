package com.example.mobiiliohjelmointiprojekti.login

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.mobiiliohjelmointiprojekti.MyStorage
import com.example.mobiiliohjelmointiprojekti.R
import com.example.mobiiliohjelmointiprojekti.database.Kayttaja
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_omat_tiedot_ikkuna.*

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private var kayttajaList = emptyList<Kayttaja>()
    lateinit var myStorage: MyStorage

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val toRegister = view.findViewById<TextView>(R.id.tvToRegister)

        toRegister.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_login_to_register)
        }

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            loginButton()
        }

        Log.i("LoginFragment", "Called ViewModelProvider.get")
        //ViewModel
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.kayttaja.observe(viewLifecycleOwner, Observer { kayttaja ->
            setData(kayttaja)
        })

        return view
    }

    private fun loginButton() {
        val tunnus = editTextUsername.text.toString()
        val salasana = editTextPasswordL.text.toString()
        d("oeh", "${kayttajaList}")
        myStorage = MyStorage()
        if (inputCheck(tunnus, salasana)) {
            kayttajaList.forEach {
                if (it.tunnus == tunnus && it.salasana == salasana) {
                    myStorage.setStoredString(tunnus)
//                    d("oeh","${viewModel.checkLogin(1)}")
                    d("oeh", myStorage.stored)
                    Toast.makeText(requireContext(), "Käyttäjä löytyi", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_login_to_omatTiedot)
                } else {

                }
            }
        } else {
            Toast.makeText(requireContext(), "Täytä kaikki kentät", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(tunnus: String, salasana : String): Boolean{
        return !(TextUtils.isEmpty(tunnus) || TextUtils.isEmpty(salasana))
    }

    fun setData(kayttaja: List<Kayttaja>) {
        this.kayttajaList = kayttaja
    }

}