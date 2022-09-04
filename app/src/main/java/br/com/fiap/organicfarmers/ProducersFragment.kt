package br.com.fiap.organicfarmers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.fiap.organicfarmers.databinding.FragmentProducersBinding

class ProducersFragment : Fragment(R.layout.fragment_producers) {

  private lateinit var binding: FragmentProducersBinding

  private var filters = arrayOf(
    FilterItem(1,"Distância"),
    FilterItem(2,"Entrega"),
    FilterItem(3,"Retirada"),
    FilterItem(4,"Certificação"),
  )

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding = FragmentProducersBinding.bind(view)

    binding?.let{
      filters.forEach { filter ->
        it.chipGroupFilter.addView(filter.toChip(requireContext()))
      }
    }

  }

}


