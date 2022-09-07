package br.com.fiap.organicfarmers

import android.view.ViewGroup
import br.com.fiap.organicfarmers.databinding.ProducersItemBinding
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.squareup.picasso.Picasso

class ProducersView(viewGroup: ViewGroup) : ATViewHolder<ProducersDTO, ProducersItemBinding> (ProducersItemBinding::inflate, viewGroup) {

    override fun bind(item: ProducersDTO) {
        binding.txtProducer.text = item.name
        binding.txtStreet.text = item.street
        binding.txtPhone.text = item.phone

        Picasso.get()
            .load(item.url)
            .into(binding.imgProducer)
    }

}

