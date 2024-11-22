package com.example.clearvolt.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clearvolt.databinding.ItemPlacaSolarBinding
import com.example.clearvolt.models.PlacaSolar

class PlacaSolarAdapter(
    private val listaPlacas: MutableList<PlacaSolar>,
    private val onCleanClick: (PlacaSolar) -> Unit
) : RecyclerView.Adapter<PlacaSolarAdapter.PlacaSolarViewHolder>() {

    inner class PlacaSolarViewHolder(val binding: ItemPlacaSolarBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacaSolarViewHolder {
        val binding = ItemPlacaSolarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlacaSolarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlacaSolarViewHolder, position: Int) {
        val placa = listaPlacas[position]
        holder.binding.txtNomePlaca.text = placa.nome
        holder.binding.txtStatusPlaca.text = placa.status

        holder.binding.btnLimparPlaca.setOnClickListener {
            onCleanClick(placa)
        }
    }

    override fun getItemCount(): Int = listaPlacas.size
}
