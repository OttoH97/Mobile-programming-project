package com.example.mobiiliohjelmointiprojekti.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mobiiliohjelmointiprojekti.R

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelFactory: LoginViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val toRegister = view.findViewById<TextView>(R.id.tvToRegister)

        toRegister.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_login_to_register)
        }

        viewModelFactory = LoginViewModelFactory()
        Log.i("LoginFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)

        return view
    }



}