package com.example.lovecalculator57.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator57.ResultPresenter
import com.example.lovecalculator57.databinding.FragmentResultBinding
import com.example.lovecalculator57.model.LoveModel
import com.example.lovecalculator57.utils.BundleKeys.KEY_FOR_LOVE
import com.example.lovecalculator57.view.ResultView

class ResultFragment : Fragment(), ResultView {

    private lateinit var binding: FragmentResultBinding
    private val presenter = ResultPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val response = arguments?.getSerializable(KEY_FOR_LOVE) as LoveModel
        presenter.getData(response)

        binding.tryAgainBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun showLove(
        firstName: String,
        secondName: String,
        percentage: String,
        result: String
    ) {
        binding.tvFname.text = firstName
        binding.tvSname.text = secondName
        binding.tvPercentage.text = percentage + "%"
        binding.tvResult.text = result
    }

}