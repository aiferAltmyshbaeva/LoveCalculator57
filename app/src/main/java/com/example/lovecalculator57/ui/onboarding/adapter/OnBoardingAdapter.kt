package com.example.lovecalculator57.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator57.R
import com.example.lovecalculator57.databinding.ItemOnboardingBinding
import com.example.lovecalculator57.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoarding(
            "Have a good time",
            "You should take the time to help those who need you",
            (R.raw.animation_first)
        ),
        OnBoarding(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            (R.raw.animation_second)
        ),
        OnBoarding(
            "Have a breakup?",
            "We have made the correction for you, don't worry." +
                    " Maybe someone is waiting for you!",
            (R.raw.animation_third)
        ),
        OnBoarding(
            null,
            "It's Fun and Many more",
            (R.raw.animation_fourth)
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) = with(binding) {
            animationView.setAnimation(onBoarding.animation)
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            btnStart.isVisible = adapterPosition == data.lastIndex
            tvTitle.isVisible = adapterPosition != data.lastIndex
            btnStart.setOnClickListener {
                onClick()
            }

        }
    }
}