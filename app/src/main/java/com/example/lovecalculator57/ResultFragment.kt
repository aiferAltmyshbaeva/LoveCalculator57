package com.example.lovecalculator57

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovecalculator57.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        if (args != null && args.containsKey("response")) {
            val response = args.getSerializable("response", LoveModel::class.java)
            binding.tvFname.text = response?.firstName
            binding.tvSname.text = response?.secondName
            binding.tvPercentage.text = response?.percentage + "%"
            binding.tvResult.text = response?.result
        }

        binding.tryAgainBtn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, StartFragment()).addToBackStack(null).commit()
        }
    }

}