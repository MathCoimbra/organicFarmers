package br.com.fiap.organicfarmers.fragment

import android.view.ViewGroup
import br.com.fiap.organicfarmers.utils.ATViewHolder
import br.com.fiap.organicfarmers.databinding.ProducersItemBinding
import br.com.fiap.organicfarmers.dtos.ProducersDTO
import com.squareup.picasso.Picasso


class ProducersView(viewGroup: ViewGroup) : ATViewHolder<ProducersDTO, ProducersItemBinding>(ProducersItemBinding::inflate, viewGroup) {

    override fun bind(item: ProducersDTO) {
        with(binding) {
            binding.txtProducer.text = item.name
            binding.txtStreet.text = item.street
            binding.txtPhone.text = item.phone

            Picasso.get()
                .load(item.url)
                .into(binding.imgProducer)

        }
    }



}

