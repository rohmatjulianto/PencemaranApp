package com.wiji.pencemaranapp.option

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.wiji.pencemaranapp.databinding.ActivityOptionBinding
import com.wiji.pencemaranapp.detail.DetailActivity
import com.wiji.pencemaranapp.resource.Resource

class OptionActivity : AppCompatActivity(), OptionClickListener {
    lateinit var binding: ActivityOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            intent.extras?.let {
                setTitle(it.get(TYPE_OPTION).toString())
            }
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        binding.apply {
            rvListOption.layoutManager = LinearLayoutManager(this@OptionActivity)
            when (intent.extras?.get(TYPE_OPTION)) {
                "Identitas" -> {
                    rvListOption.adapter = OptionAdapter(this@OptionActivity, Resource.menu)
                }
                "Materi" -> {
                    rvListOption.adapter = OptionAdapter(this@OptionActivity, Resource.menu_materi)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val TYPE_OPTION = "TYPE"
    }

    override fun onClick(value: String) {
        Log.d("yy", "onClick: $value")
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.TYPE_OPTION, value)

        when (value) {
            Resource.menu.get(0)  -> {
                intent.putExtra(DetailActivity.CONTENT, Resource.kompetensi)
                startActivity(intent)

            }
            Resource.menu.get(1) -> {
                intent.putExtra(DetailActivity.CONTENT, Resource.indikator_tujuan)
                startActivity(intent)
            }
            Resource.menu_materi.get(0) -> {
                intent.putExtra(DetailActivity.CONTENT, Resource.materi_air)
                startActivity(intent)
            }
            Resource.menu_materi.get(1) -> {
                intent.putExtra(DetailActivity.CONTENT, Resource.materi_tanah)
                startActivity(intent)
            }
            Resource.menu_materi.get(2) -> {
                intent.putExtra(DetailActivity.CONTENT, Resource.materi_udara)
                startActivity(intent)
            }
            Resource.menu_materi.get(3) -> {
                intent.putExtra(DetailActivity.CONTENT, Resource.materi_parameter)
                startActivity(intent)
            }
        }
    }
}