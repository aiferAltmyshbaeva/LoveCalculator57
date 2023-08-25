package com.example.lovecalculator57.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovecalculator57.R
import com.example.lovecalculator57.ResultPresenter
import com.example.lovecalculator57.databinding.FragmentResultBinding
import com.example.lovecalculator57.model.LoveModel
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

        val args = arguments
        if (args != null && args.containsKey("response")) {
            val response = args.getSerializable("response", LoveModel::class.java)
            if (response != null) {
                presenter.getData(response)
            }
        }

        binding.tryAgainBtn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, StartFragment()).addToBackStack(null).commit()
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