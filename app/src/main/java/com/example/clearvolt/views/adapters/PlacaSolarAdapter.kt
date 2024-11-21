package com.example.clearvolt.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clearvolt.R
import com.example.clearvolt.models.PlacaSolar

class PlacaSolarAdapter(
    private val listaPlacas: MutableList<PlacaSolar>
) : RecyclerView.Adapter<PlacaSolarAdapter.PlacaSolarViewHolder>() {

    // Classe interna para gerenciar os itens do RecyclerView
    inner class PlacaSolarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNomePlaca: TextView = view.findViewById(R.id.txtNomePlaca)
        val txtStatusPlaca: TextView = view.findViewById(R.id.txtStatusPlaca)
        val btnLimparPlaca: Button = view.findViewById(R.id.btnLimparPlaca)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacaSolarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_placa_solar, parent, false)
        return PlacaSolarViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlacaSolarViewHolder, position: Int) {
        val placaSolar = listaPlacas[position]
        holder.txtNomePlaca.text = placaSolar.nome
        holder.txtStatusPlaca.text = placaSolar.status

        // Ação para o botão "Limpar Placa"
        holder.btnLimparPlaca.setOnClickListener {
            placaSolar.status = "Limpo"
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = listaPlacas.size
}
