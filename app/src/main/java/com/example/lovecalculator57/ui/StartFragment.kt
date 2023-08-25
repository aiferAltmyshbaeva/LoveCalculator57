package com.example.lovecalculator57.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator57.Presenter
import com.example.lovecalculator57.R
import com.example.lovecalculator57.databinding.FragmentStartBinding
import com.example.lovecalculator57.model.LoveModel
import com.example.lovecalculator57.utils.BundleKeys.KEY_FOR_LOVE
import com.example.lovecalculator57.view.LoveView

class StartFragment : Fragment(), LoveView {

    private lateinit var binding: FragmentStartBinding
    private val presenter = Presenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                presenter.getLoveResult(
                    firstEd.text.toString(),
                    secondEd.text.toString()
                )
            }
        }
    }

    override fun navigationToResultScreen(loveModel: LoveModel) {
        findNavController().navigate(R.id.resultFragment, bundleOf(KEY_FOR_LOVE to loveModel))
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }
}

