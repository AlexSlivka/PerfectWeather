package com.example.perfectweather.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.perfectweather.R
import com.example.perfectweather.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false
        )

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        /** Setting up LiveData observation relationship **/
        viewModel.word.observe(viewLifecycleOwner, Observer { newWord ->
            binding.textView.text = newWord
        })

        binding.button.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_citySelectionFragment)
        }

        binding.button2.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_settingsFragment)
        }

        binding.button5.setOnClickListener { onCorrect() }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    //    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun onCorrect() {
        viewModel.onCorrect()
    }



}