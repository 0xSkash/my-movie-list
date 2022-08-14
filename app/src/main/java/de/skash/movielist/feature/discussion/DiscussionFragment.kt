package de.skash.movielist.feature.discussion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.skash.movielist.databinding.FragmentDiscussionBinding

class DiscussionFragment : Fragment() {

    private var _binding: FragmentDiscussionBinding? = null
    private val binding: FragmentDiscussionBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDiscussionBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}