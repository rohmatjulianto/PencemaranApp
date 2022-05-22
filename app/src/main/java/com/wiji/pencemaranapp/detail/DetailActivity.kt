package com.wiji.pencemaranapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.wiji.pencemaranapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)

            intent.extras?.let {
                setTitle(it.get(TYPE_OPTION).toString())
            }
        }

        val html = "<html><body>${intent.extras?.getString(CONTENT)}</body></html>"
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadDataWithBaseURL("",html, "text/html", "utf-8", null)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val TYPE_OPTION = "TYPE"
        const val CONTENT ="CONTENT"
    }
}