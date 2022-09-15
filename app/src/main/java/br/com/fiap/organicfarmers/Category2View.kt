package br.com.fiap.organicfarmers

import android.view.ViewGroup
import br.com.fiap.organicfarmers.databinding.Category2ItemBinding
import com.squareup.picasso.Picasso

class Category2View(viewGroup: ViewGroup) : ATViewHolder<Category2DTO, Category2ItemBinding> (Category2ItemBinding::inflate, viewGroup) {

    override fun bind(item: Category2DTO) {
        binding.txtCategory2.text = item.name

        Picasso.get()
            .load(item.url)
            .into(binding.imgCategory2)
    }

}

