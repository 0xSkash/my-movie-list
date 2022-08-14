package de.skash.movielist.feature.mylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.skash.movielist.databinding.FragmentMyListBinding

class MyListFragment : Fragment() {

    private var _binding: FragmentMyListBinding? = null
    private val binding: FragmentMyListBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMyListBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}