package com.example.clearvolt.views.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clearvolt.databinding.FragmentDashboardBinding
import com.example.clearvolt.models.PlacaSolar
import com.example.clearvolt.views.adapters.PlacaSolarAdapter

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    // Lista de placas solares
    private val listaPlacas = mutableListOf<PlacaSolar>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar o RecyclerView
        val adapter = PlacaSolarAdapter(listaPlacas)
        binding.recyclerViewPlacas.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPlacas.adapter = adapter

        // Configurar o botão para adicionar novas placas
        binding.btnAdicionarPlaca.setOnClickListener {
            // Adiciona uma nova placa na lista e atualiza o adapter
            val novaPlaca = PlacaSolar("Placa ${listaPlacas.size + 1}", "Não Limpo")
            listaPlacas.add(novaPlaca)
            adapter.notifyItemInserted(listaPlacas.size - 1)

            Toast.makeText(requireContext(), "Nova placa adicionada!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
