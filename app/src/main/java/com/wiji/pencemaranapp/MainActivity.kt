package com.wiji.pencemaranapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wiji.pencemaranapp.databinding.ActivityMainBinding
import com.wiji.pencemaranapp.databinding.LayoutMenuBinding
import com.wiji.pencemaranapp.detail.DetailActivity
import com.wiji.pencemaranapp.option.OptionActivity
import com.wiji.pencemaranapp.resource.Resource

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            initMenu(menuIdentitas, "Identitas")
            initMenu(menuEvaluasi, "Evaluasi")
            initMenu(menuMateri, "Materi")
            initMenu(menuSimulasi, "Simulasi")
        }
    }

    fun initMenu(binding: LayoutMenuBinding, title: String){
        binding.apply {
            titleMenu.text = title
            root.setOnClickListener{
                if (title.equals("Evaluasi")){
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.TYPE_OPTION, title)
                    intent.putExtra(DetailActivity.CONTENT, Resource.evaluasi)
                    startActivity(intent)
                }else{
                    val intent = Intent(this@MainActivity, OptionActivity::class.java)
                    intent.putExtra(OptionActivity.TYPE_OPTION, title)
                    startActivity(intent)
                }

            }
        }
    }
}