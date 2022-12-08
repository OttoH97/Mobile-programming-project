package com.example.mobiiliohjelmointiprojekti.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mobiiliohjelmointiprojekti.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    //private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val toRegister = view.findViewById<TextView>(R.id.tvToRegister)

        toRegister.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_login_to_register)
        }

        Log.i("LoginFragment", "Called ViewModelProvider.get")
        //ViewModel
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.kayttaja.observe(viewLifecycleOwner, Observer { kayttaja ->

        })


        return view
    }

//    private fun loginButton() {
//        if (editTextUsername.text == null || editTextPasswordL.text == null) {
//            Toast.makeText(requireContext(), "Täytä kaikki kentät", Toast.LENGTH_LONG).show()
//        } else {
//            uiScope.launch {
//                val usersNames = repository.getUserName(inputUsername.value!!)
//                if (usersNames != null) {
//                    if(usersNames.passwrd == inputPassword.value){
//                        inputUsername.value = null
//                        inputPassword.value = null
//                        _navigatetoUserDetails.value = true
//                    }else{
//                        _errorToastInvalidPassword.value = true
//                    }
//                } else {
//                    _errorToastUsername.value = true
//                }
//            }
//        }
//    }

}