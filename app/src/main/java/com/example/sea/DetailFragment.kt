package com.example.sea

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.DotsIndicatorDecoration
import com.example.SliderItemAdapter
import com.example.sea.databinding.FragmentDetailBinding
import com.google.android.material.slider.Slider

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: SliderItemAdapter

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = SliderItemAdapter(SliderItemAdapter.SliderItemDiff())
        adapter.submitList(listOf(
            R.drawable.up_coming_show_3,
            R.drawable.up_coming_show_1,
            R.drawable.up_coming_show_2,
        ))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.recycler.adapter = adapter
        PagerSnapHelper().attachToRecyclerView(binding.recycler)
        binding.recycler.addItemDecoration(
            DotsIndicatorDecoration(requireContext(), 30f).apply {
                setDotColors(
                    ContextCompat.getColor(requireContext(), R.color.md_theme_light_primary),
                    ContextCompat.getColor(requireContext(), R.color.md_theme_light_surfaceVariant),
                )
            }
        )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
        startAutoSliding()
    }

    private fun startAutoSliding() {
        val delayMillis = 3000L
        val runnable = object : Runnable {
            override fun run() {
                val nextItem = (binding.recycler.layoutManager as LinearLayoutManager)
                    .findFirstVisibleItemPosition() + 1

                if (nextItem < (binding.recycler.adapter?.itemCount ?: 0)) {
                    binding.recycler.smoothScrollToPosition(nextItem)
                } else {
                    binding.recycler.smoothScrollToPosition(0)
                }
                handler.postDelayed(this, delayMillis)
            }
        }
        handler.postDelayed(runnable, delayMillis)
    }

    private fun setText() {
        val title1 = "410m away Map"
        val builder = SpannableStringBuilder(title1)
        context?.let {
            builder.setSpan(ForegroundColorSpan(
                ContextCompat.getColor( it, R.color.md_theme_light_primary)
            ), title1.length - 3, title1.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        }
        binding.spanText.text = builder
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null)
        _binding = null
    }
}