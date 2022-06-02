package com.example.wasteclassificationapps.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.wasteclassificationapps.R
import com.example.wasteclassificationapps.databinding.ActivityMainBinding
import com.example.wasteclassificationapps.infoTips.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val CAMERA_RESULT = 200

        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    this,
                    "Permission not allowed",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = " "

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
        binding.imgDetailOrganik.setOnClickListener {
            val intent = Intent(this@MainActivity, OrganikActivity::class.java)
            startActivity(intent)
        }
        binding.imgDetailAnorganik.setOnClickListener {
            val intent = Intent(this@MainActivity, AnorganikActivity::class.java)
            startActivity(intent)
        }
        binding.imgDetailB3.setOnClickListener {
            val intent = Intent(this@MainActivity, B3Activity::class.java)
            startActivity(intent)
        }

        binding.btnImgTips1.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailTips1Activity::class.java)
            startActivity(intent)
        }
        binding.btnImgTips2.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailTips2Activity::class.java)
            startActivity(intent)
        }
        binding.btnImgTips3.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailTips3Activity::class.java)
            startActivity(intent)
        }
        binding.btnImgTips4.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailTips4Activity::class.java)
            startActivity(intent)
        }
        binding.btnImgTips5.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailTips5Activity::class.java)
            startActivity(intent)
        }
        binding.btnImgTips6.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailTips6Activity::class.java)
            startActivity(intent)
        }
        binding.btnImgTips7.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailTips7Activity::class.java)
            startActivity(intent)
        }

        binding.btnCam.setOnClickListener { startCameraX() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.options ->{
                Intent(this, OptionsActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startCameraX() {
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

}