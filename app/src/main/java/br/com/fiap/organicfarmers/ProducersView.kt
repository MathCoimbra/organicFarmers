package br.com.fiap.organicfarmers

import android.content.Intent
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentResultListener
import br.com.fiap.organicfarmers.databinding.ProducersItemBinding
import com.squareup.picasso.Picasso


class ProducersView(viewGroup: ViewGroup) : ATViewHolder<ProducersDTO, ProducersItemBinding> (ProducersItemBinding::inflate, viewGroup) {

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

