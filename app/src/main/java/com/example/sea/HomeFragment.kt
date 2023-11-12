package com.example.sea

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.DotsIndicatorDecoration
import com.example.GridItemAdapter
import com.example.SliderItemAdapter
import com.example.UpcomingShowAdapter
import com.example.data.gridItems
import com.example.data.upComingShowItems
import com.example.sea.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: GridItemAdapter
    private lateinit var upComingAdapter: UpcomingShowAdapter
    private lateinit var sliderAdapter: SliderItemAdapter

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter  = GridItemAdapter(GridItemAdapter.GridDataDiff())
        upComingAdapter  = UpcomingShowAdapter(UpcomingShowAdapter.UpComingItemDiff()) {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        sliderAdapter  = SliderItemAdapter(SliderItemAdapter.SliderItemDiff())
        adapter.submitList(gridItems)
        upComingAdapter.submitList(upComingShowItems)
        sliderAdapter.submitList(listOf(
            R.drawable.up_coming_show_2,
            R.drawable.up_coming_show_3,
            R.drawable.up_coming_show_1,
        ))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.recyclerGrid.adapter = adapter
        binding.upComeRecycler.adapter = upComingAdapter
        binding.recycler.adapter = sliderAdapter
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

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null)
        _binding = null
    }
}