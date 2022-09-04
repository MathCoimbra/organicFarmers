package br.com.fiap.organicfarmers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.organicfarmers.databinding.FragmentProducersBinding
import co.tiagoaguiar.atway.ui.adapter.ATAdapter

class ProducersFragment : Fragment(R.layout.fragment_producers) {

  private lateinit var binding: FragmentProducersBinding

  private val categoryAdapter = ATAdapter( { CategoryView(it)})
  private val category2Adapter = ATAdapter( { Category2View(it)})

  private var filters = arrayOf(
    FilterItem(1,"Distância"),
    FilterItem(2,"Entrega"),
    FilterItem(3,"Retirada"),
    FilterItem(4,"Certificação"),
  )

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    categoryAdapter.items = arrayListOf(
      Category(1, "https://www.stefaniamaffeinutrizionista.it/wp-content/uploads/2021/03/Progetto-senza-titolo-3-300x240.jpg" , "Frutas", 222222),
      Category(2, "https://i.blogs.es/3c80ad/lechugas2/1024_682.jpg" , "Verduras", 222222),
      Category(3, "https://th.bing.com/th/id/OIP.1Hy147tXvZGmjeyXhebFSAAAAA?pid=ImgDet&rs=1" , "Legumes", 222222),
      Category(4, "https://th.bing.com/th/id/R.a4a6ab23fa9257c964f1322d31bcc6d3?rik=uPu6zFNptEglTA&riu=http%3a%2f%2fwww.osevauni.cz%2fdrobne-baleni%2fimg%2fhorcice.jpg&ehk=FmYsYdBDBgBwhnq6L3B%2ff6CwA5zeZCm3svpnll5vk7c%3d&risl=&pid=ImgRaw&r=0" , "Grãos", 222222),
    )

    category2Adapter.items = arrayListOf(
      Category2(1, "https://th.bing.com/th/id/OIP.X7kD66VkGRH8TmXuvuovDQHaE8?pid=ImgDet&w=750&h=500&rs=1"),
      Category2(2, "https://www.verbraucherzentrale.de/sites/default/files/styles/article_full_image_desktop/public/2017-11/obst_gemuese_gpointstudio_fotolia.jpg?h=871ba2d0&itok=mT0x61Vx")
    )

    binding = FragmentProducersBinding.bind(view)

    binding?.let{

      it.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
      it.rvCategory.adapter = categoryAdapter

      it.rvCategory2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
      it.rvCategory2.adapter = category2Adapter

      filters.forEach { filter ->
        it.chipGroupFilter.addView(filter.toChip(requireContext()))
      }
    }

  }

}


