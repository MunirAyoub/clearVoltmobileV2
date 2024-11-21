package com.example.clearvolt.views.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clearvolt.R
import com.example.clearvolt.databinding.FragmentHomeBinding
import com.example.clearvolt.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
class ProfileFragment : Fragment() {

private val binding by lazy {
    FragmentProfileBinding.inflate(layoutInflater)
}

private val authenticate by lazy {
    FirebaseAuth.getInstance()
}

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    //binding.

    return binding.root
}
}