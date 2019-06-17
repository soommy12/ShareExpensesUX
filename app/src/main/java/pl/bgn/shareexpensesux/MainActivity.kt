package pl.bgn.shareexpensesux

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import pl.bgn.shareexpensesux.dummy.DummyContent

class MainActivity : AppCompatActivity(), ProfileFragment.OnFragmentInteractionListener, GroupFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_profile -> {
                supportActionBar?.title = "Profile"
                supportFragmentManager.beginTransaction().replace(R.id.container, ProfileFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_groups -> {
                supportActionBar?.title = "Groups"
                supportFragmentManager.beginTransaction().replace(R.id.container, GroupFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_bills -> {
                supportActionBar?.title = "Your Bills"
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        supportActionBar?.title = "Profile"
        supportFragmentManager.beginTransaction().replace(R.id.container, ProfileFragment()).commit()
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
