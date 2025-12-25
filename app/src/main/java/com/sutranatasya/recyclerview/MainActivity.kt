package com.sutranatasya.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sutranatasya.recyclerview.adapter.AdapterTeamBola
import com.sutranatasya.recyclerview.databinding.ActivityMainBinding
import com.sutranatasya.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = listOf(
            Pemain("Thibaut Courtois", R.drawable.courtois, "Penjaga Gawang", "2.00 m", "Bree, Belgia", "11 Mei 1992"),
            Pemain("Karim Benzema", R.drawable.benzema, "Penyerang", "1.85 m", "Lyon, Prancis", "19 Desember 1987"),
            Pemain("Marcelo Vieira da Silva", R.drawable.marcello, "Belakang", "1.74 m", "Rio de Janeiro, Brasil", "12 Mei 1988"),
            Pemain("Sergio Ramos Garcia", R.drawable.ramos, "Belakang", "1.84 m", "Camas, Spanyol", "30 Maret 1986"),
            Pemain("Zinedine Yazid Zidane", R.drawable.zidan, "Pelatih", "1.85 m", "Marseille, Prancis", "23 Juni 1972")
        )

        binding.list.adapter =
            AdapterTeamBola(listPemain, object : AdapterTeamBola.OnClickListener {
                override fun detailData(item: Pemain) {
                    TODO("Not yet implemented")
                }
            })
    }
}
