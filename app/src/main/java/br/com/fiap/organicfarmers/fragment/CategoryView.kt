package br.com.fiap.organicfarmers.fragment

import android.view.ViewGroup
import br.com.fiap.organicfarmers.utils.ATViewHolder
import br.com.fiap.organicfarmers.databinding.CategoryItemBinding
import br.com.fiap.organicfarmers.dtos.CategoryDTO
import com.squareup.picasso.Picasso

class CategoryView(viewGroup: ViewGroup) : ATViewHolder<CategoryDTO, CategoryItemBinding>(CategoryItemBinding::inflate, viewGroup) {

    override fun bind(item: CategoryDTO) {
        binding.txtCategory.text = item.name

        Picasso.get()
            .load(item.url)
            .into(binding.imgCategory)
    }

}