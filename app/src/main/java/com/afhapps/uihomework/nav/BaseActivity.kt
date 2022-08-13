package com.afhapps.uihomework.nav

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.afhapps.uihomework.MainActivity
import com.afhapps.uihomework.R
import com.afhapps.uihomework.databinding.ActivityBaseBinding
import com.afhapps.uihomework.notes.ui.Note

class BaseActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this, binding.drLayout, R.string.open, R.string.close)
        binding.drLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.naview.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home-> {
                    setCurrentFragment(Home())
                    binding.drLayout.close()
                }
               R.id.send-> {
                         setCurrentFragment(Send())
                         binding.drLayout.close()
               }
                R.id.email->{
                    setCurrentFragment(Email())
                    binding.drLayout.close()
                }
                R.id.notesicon->{
                    setCurrentFragment(Note())
                    binding.drLayout.close()

                }
                R.id.logout->{
                    val alert = AlertDialog.Builder(this)
                        .setIcon(R.drawable.ic_exit)
                        .setTitle("Exit")
                        .setMessage("Do you want to logout?")
                        .setPositiveButton("Yes"){ dialog: DialogInterface,i:Int->
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                            finish()

                        }
                        .setNegativeButton("No"){ dialog: DialogInterface,i:Int->
                            dialog.cancel()
                        }
                    val alertDialog = alert.create()
                    alertDialog.show()

                }



            }
            false
        }


        }


    private fun setCurrentFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.flfragemnt, fragment)
            commit()
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return false
    }
}


