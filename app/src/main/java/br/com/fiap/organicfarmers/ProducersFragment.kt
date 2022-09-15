package br.com.fiap.organicfarmers

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.organicfarmers.databinding.FragmentProducersBinding

class ProducersFragment: Fragment(R.layout.fragment_producers) {

  private lateinit var binding: FragmentProducersBinding

  private val categoryAdapter = ATAdapter( { CategoryView(it)})
  private val category2Adapter = ATAdapter( { Category2View(it)})
  private val producersAdapter = ATAdapter(
    viewHolder = { ProducersView(it) },
    onItemClick = { producer -> parentFragmentManager.setFragmentResult("producer-details", bundleOf("open-activity" to producer.id))
    }
  )

  private var filters = arrayOf(
    FilterItem(1,"Distância"),
    FilterItem(2,"Entrega"),
    FilterItem(3,"Retirada"),
    FilterItem(4,"Certificação"),
  )

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    categoryAdapter.items = arrayListOf(
      CategoryDTO(1, "https://www.stefaniamaffeinutrizionista.it/wp-content/uploads/2021/03/Progetto-senza-titolo-3-300x240.jpg" , "Frutas", 222222),
      CategoryDTO(2, "https://i.blogs.es/3c80ad/lechugas2/1024_682.jpg" , "Verduras", 222222),
      CategoryDTO(3, "https://th.bing.com/th/id/OIP.1Hy147tXvZGmjeyXhebFSAAAAA?pid=ImgDet&rs=1" , "Legumes", 222222),
      CategoryDTO(4, "https://th.bing.com/th/id/R.a4a6ab23fa9257c964f1322d31bcc6d3?rik=uPu6zFNptEglTA&riu=http%3a%2f%2fwww.osevauni.cz%2fdrobne-baleni%2fimg%2fhorcice.jpg&ehk=FmYsYdBDBgBwhnq6L3B%2ff6CwA5zeZCm3svpnll5vk7c%3d&risl=&pid=ImgRaw&r=0" , "Grãos", 222222),
    )

    category2Adapter.items = arrayListOf(
      Category2DTO(1, "https://th.bing.com/th/id/OIP.X7kD66VkGRH8TmXuvuovDQHaE8?pid=ImgDet&w=750&h=500&rs=1", "Cestas de orgânicos"),
      Category2DTO(2, "https://www.verbraucherzentrale.de/sites/default/files/styles/article_full_image_desktop/public/2017-11/obst_gemuese_gpointstudio_fotolia.jpg?h=871ba2d0&itok=mT0x61Vx", "Orgânicos avulsos" )
    )

    producersAdapter.items = arrayListOf(
      ProducersDTO(1, "https://ibassets.com.br/ib.store.image.medium/m-f2e96c63cb934a3b96dda16a078ac53b.jpeg", "Empório Victor Orgâniico", "Rua Joaquim Geraldo, 10 - Jardim América, Jardim América","(35)99935-4521"),
      ProducersDTO(4, "https://ibassets.com.br/ib.store.image.medium/m-f2e96c63cb934a3b96dda16a078ac53b.jpeg", "Empório Raissa Orgânico", "Rua 21 de Setembro, 50 - Vila Robertina, São Paulo", "(11)99945-1248"),
      ProducersDTO(5, "https://ibassets.com.br/ib.store.image.medium/m-f2e96c63cb934a3b96dda16a078ac53b.jpeg", "Empório Carlos Graos", "Rua 9 de Setembro, 15 - Chácara Gaivotas, São Paulo", "(11)99954-3578"),
      ProducersDTO(6, "https://ibassets.com.br/ib.store.image.medium/m-f2e96c63cb934a3b96dda16a078ac53b.jpeg", "Empório Rafael Orgânico", "Rua Abaúna, 20 - Vila Moinho Velho, São Paulo", "(11)99548-2145"),
      ProducersDTO(9, "https://ibassets.com.br/ib.store.image.medium/m-f2e96c63cb934a3b96dda16a078ac53b.jpeg", "Empório Matheus Verduras", "Rua Abdon Batista, 200 - Parque das Paineiras, São Paulo", "(11)99885-7545")

    )

    binding = FragmentProducersBinding.bind(view)

    binding?.let{

      it.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
      it.rvCategory.adapter = categoryAdapter

      it.rvCategory2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
      it.rvCategory2.adapter = category2Adapter

      it.rvProducers.layoutManager = LinearLayoutManager(requireContext())
      it.rvProducers.adapter = producersAdapter

      filters.forEach { filter ->
        it.chipGroupFilter.addView(filter.toChip(requireContext()))
      }

    }

  }

}


