package com.example.mobiiliohjelmointiprojekti.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mobiiliohjelmointiprojekti.R
import com.example.mobiiliohjelmointiprojekti.login.LoginViewModel
import com.example.mobiiliohjelmointiprojekti.login.LoginViewModelFactory

class RegisterFragment : Fragment() {

    private lateinit var viewModel: RegisterViewModel
    private lateinit var viewModelFactory: RegisterViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        viewModelFactory = RegisterViewModelFactory()
        Log.i("RegisterFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this, viewModelFactory).get(RegisterViewModel::class.java)

        return view
    }

}