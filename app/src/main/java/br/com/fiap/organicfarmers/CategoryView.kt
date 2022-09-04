package br.com.fiap.organicfarmers

import android.view.ViewGroup
import br.com.fiap.organicfarmers.databinding.CategoryItemBinding
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.squareup.picasso.Picasso

class CategoryView(viewGroup: ViewGroup) : ATViewHolder<Category, CategoryItemBinding> (CategoryItemBinding::inflate, viewGroup) {

    override fun bind(item: Category) {
        binding.txtCategory.text = item.name

        Picasso.get()
            .load(item.url)
            .into(binding.imgCategory)
    }

}