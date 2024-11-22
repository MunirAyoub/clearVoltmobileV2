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
    private lateinit var adapter: PlacaSolarAdapter
    private val listaPlacas = mutableListOf<PlacaSolar>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        setupRecyclerView()
        setupListeners()

        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = PlacaSolarAdapter(listaPlacas, onCleanClick = { placa ->
            placa.status = "Limpo"
            adapter.notifyDataSetChanged()
            Toast.makeText(requireContext(), "Placa ${placa.nome} foi limpa!", Toast.LENGTH_SHORT).show()
        })

        binding.recyclerViewPlacas.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPlacas.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnAdicionarPlaca.setOnClickListener {
            val novaPlaca = PlacaSolar(nome = "Placa ${listaPlacas.size + 1}", status = "Sujo")
            listaPlacas.add(novaPlaca)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
