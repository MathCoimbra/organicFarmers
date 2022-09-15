package br.com.fiap.organicfarmers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.fiap.organicfarmers.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    /* referência ao xml utilizando viewBinding */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupViews()

        binding.btnNav.setOnItemSelectedListener() { item ->
            when(item.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.cart -> {
                    val intent = Intent(this, CartActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        supportFragmentManager
            .setFragmentResultListener("producer-details", this) {
                    _, bundle ->
                val result = bundle.getBoolean("open-activity")

                if (result) {
                    val intent = Intent(this, ProducerActivity::class.java)
                    startActivity(intent)
                }
        }

    }

    private fun setupViews() {
        val tabLayout = binding.addTab
        val viewPager = binding.addViewPager
        val adapter = TabViewPagerAdapter(this)
        viewPager.adapter = adapter
        viewPager.isUserInputEnabled = false

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(adapter.tabs[position])
        }.attach()
    }

}

class TabViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    val tabs = arrayOf(R.string.producers, R.string.fairs, R.string.marketplaces)
    val fragments = arrayOf(ProducersFragment(), ProducersFragment(), ProducersFragment())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}

