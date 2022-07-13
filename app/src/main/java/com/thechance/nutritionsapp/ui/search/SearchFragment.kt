package com.thechance.nutritionsapp.ui.search
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import com.thechance.nutritionsapp.data.DataManager
import com.thechance.nutritionsapp.databinding.FragmentSearchBinding
import com.thechance.nutritionsapp.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private var keyword : String ?= null
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate
    private lateinit var dataManager: DataManager

    override fun setup() {
        dataManager = DataManager(requireContext())

        binding.edtTxtSearch.addTextChangedListener {
            keyword = it.toString()
        }
        binding.mealRecyclerView.layoutManager = GridLayoutManager(context, 1)
        val customAdapter =
            SearchAdapter(binding.mealRecyclerView.context, dataManager.getSpecificNutrition(keyword.toString()))
        binding.mealRecyclerView.adapter = customAdapter

        /* binding.mealRecyclerView.setHasFixedSize(true)
         val layoutManager = LinearLayoutManager(context)
         layoutManager.orientation = RecyclerView.VERTICAL
         binding.mealRecyclerView.layoutManager = layoutManager*/
    }
}