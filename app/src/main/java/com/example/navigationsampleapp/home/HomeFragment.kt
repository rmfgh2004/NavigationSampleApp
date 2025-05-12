package com.example.navigationsampleapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.navigationsampleapp.R
import com.example.navigationsampleapp.databinding.FragmentHomeBinding
import com.example.navigationsampleapp.detail.DetailFragmentArgs

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewmodel = viewModel
            fragment = this@HomeFragment
        }
    }

    fun onSendClick() {
        val action =
            HomeFragmentDirections.actionHomeToDetail(text = viewModel.messageText.value ?: "empty")
        findNavController().navigate(action)
    }

}