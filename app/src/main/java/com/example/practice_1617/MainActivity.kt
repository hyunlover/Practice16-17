package com.example.practice_1617
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val themeSwitchButton: Button = findViewById(R.id.button)
        themeSwitchButton.setOnClickListener {
            toggleTheme()
        }
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        invalidateOptionsMenu()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val menuItemLight = menu?.findItem(R.id.light)
        if (menuItemLight != null) {
            menuItemLight.setIcon(getAppropriateIconNight())
        }
        val menuItemDark = menu?.findItem(R.id.dark)
        if (menuItemDark != null) {
            menuItemDark.setIcon(getAppropriateIconLight())
        }
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.itemId){
            R.id.light -> toggleTheme_light()
            R.id.dark ->  toggleTheme_dark()
            R.id.themes -> toggleTheme()
            R.id.about_menu_item -> about_menu_open()
        }
        return super.onOptionsItemSelected(item)
    }
    fun toggleTheme_light(){
        val currentNightMode = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            recreate()
        }
    }
    fun toggleTheme_dark(){
        val currentNightMode = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_NO) {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            recreate()
        }
    }
    fun toggleTheme() {
        val currentNightMode = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        recreate()
    }

    private fun about_menu_open() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }


    private fun getAppropriateIconLight(): Int {
        return if (isDarkTheme()) {
            R.drawable.dark
        } else {
            R.drawable.dark
        }
    }
    private fun getAppropriateIconNight(): Int {
        return if (isDarkTheme()) {
            R.drawable.light
        } else {
            R.drawable.light
        }
    }
    private fun isDarkTheme(): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }

}
