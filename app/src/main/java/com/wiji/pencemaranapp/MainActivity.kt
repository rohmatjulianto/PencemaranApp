package com.wiji.pencemaranapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
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

        with(binding) {
            initMenu(menuIdentitas, "Identitas", R.drawable.ic_baseline_info_24)
            initMenu(menuEvaluasi, "Evaluasi", R.drawable.ic_baseline_assessment_24)
            initMenu(menuMateri, "Materi", R.drawable.ic_baseline_library_books_24)
            initMenu(menuSimulasi, "Simulasi", R.drawable.ic_baseline_run_circle_24)
        }
    }

    fun initMenu(binding: LayoutMenuBinding, title: String, icon: Int) {
        binding.apply {
            titleMenu.text = title
            img.setImageResource(icon)
            root.setOnClickListener {
                if (title.equals("Evaluasi")) {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.TYPE_OPTION, title)
                    intent.putExtra(DetailActivity.CONTENT, Resource.evaluasi)
                    startActivity(intent)
                } else if (title.equals("Simulasi")) {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.TYPE_OPTION, title)
                    intent.putExtra(DetailActivity.CONTENT, Resource.simulasi)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@MainActivity, OptionActivity::class.java)
                    intent.putExtra(OptionActivity.TYPE_OPTION, title)
                    startActivity(intent)
                }

            }
        }
    }
}