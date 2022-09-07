package com.franzueto.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.franzueto.lab1.databinding.ActivityDisplayMessageBinding

class DisplayMessageFragment : Fragment() {

    private var _binding: ActivityDisplayMessageBinding? = null
    private val binding get() = _binding!!

    val arg: DisplayMessageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityDisplayMessageBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.messageTextView.apply {
            text = arg.message
        }
    }
}