package uts.c14210035.myrecview4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import uts.c14210035.myrecview4.ui.theme.MyRecView4Theme

class MainActivity : ComponentActivity() {

    private lateinit var _nama :Array<String>
    private lateinit var _karakter : Array<String>
    private lateinit var _deskripsi : Array<String>
    private lateinit var _gambar : Array<String>

    private var arWayang = arrayListOf<Wayang>()

    private lateinit var _rvWayang : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        _rvWayang = findViewById<RecyclerView>(R.id.rvWayang)

        _rvWayang.layoutManager = StaggeredGridLayoutManager(
            2, LinearLayoutManager.VERTICAL
        )
        _rvWayang.adapter = adapterRecView(arWayang)

        SiapkanData()
        TambahData()
        TampilkanData()

    }

    fun SiapkanData(){
        _nama = resources.getStringArray(R.array.namaWayang)
        _deskripsi = resources.getStringArray(R.array.deskripsiWayang)
        _karakter = resources.getStringArray(R.array.karakterUtamaWayang)
        _gambar = resources.getStringArray(R.array.gambarWayang)
    }

    fun TambahData(){
        for (position in _nama.indices){
            val data = Wayang(
                _gambar[position],
                _nama[position],
                _karakter[position],
                _deskripsi[position]
            )
            arWayang.add(data)
        }
    }

    fun TampilkanData(){
        _rvWayang.layoutManager = LinearLayoutManager(this)
        _rvWayang.adapter = adapterRecView(arWayang)
    }
}

