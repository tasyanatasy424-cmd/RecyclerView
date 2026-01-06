package com.sutranatasya.recyclerview

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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

        // 🔴 WAJIB: set Toolbar supaya menu muncul
        setSupportActionBar(binding.toolbar)

        val listPemain = listOf(
            Pemain("Thibaut Courtois", R.drawable.courtois, "Penjaga Gawang", "2.00 m", "Bree, Belgia", "11 Mei 1992"),
            Pemain("Karim Benzema", R.drawable.benzema, "Penyerang", "1.85 m", "Lyon, Prancis", "19 Desember 1987"),
            Pemain("Marcelo Vieira da Silva", R.drawable.marcello, "Belakang", "1.74 m", "Rio de Janeiro, Brasil", "12 Mei 1988"),
            Pemain("Sergio Ramos Garcia", R.drawable.ramos, "Belakang", "1.84 m", "Camas, Spanyol", "30 Maret 1986"),
            Pemain("Zinedine Yazid Zidane", R.drawable.zidan, "Pelatih", "1.85 m", "Marseille, Prancis", "23 Juni 1972")
        )

        binding.list.layoutManager = LinearLayoutManager(this)

        binding.list.adapter = AdapterTeamBola(listPemain, object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = findViewById<ImageView>(R.id.image_pemain)
                    val nama = findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = findViewById<TextView>(R.id.txtTglLahir)
                    val btn = findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item.foto)
                    nama.text = item.nama
                    posisi.text = item.posisi
                    tinggi.text = item.tinggi
                    tempatlahir.text = item.tempatlahir
                    tgllahir.text = item.tgllahir

                    btn.setOnClickListener { dismiss() }
                }.show()
            }
        })
    }

    // ✅ JANGAN return super
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // ✅ Tangkap klik menu dengan benar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.myprofile -> {
                startActivity(Intent(this, Profile::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
