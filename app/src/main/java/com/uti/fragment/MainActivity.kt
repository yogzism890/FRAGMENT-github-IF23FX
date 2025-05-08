package com.uti.fragment

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    def variable menu
//    var menu = "1"
    lateinit var menu : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()




        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    openFragment1()

//        buat event1
//        event img_menu1
        binding.menu1.setOnClickListener {
//            buka fragmen menu1
            openFragment1()
        }
//        event img_menu2
        binding.imgMenu2.setOnClickListener {
            menu = "2"
//            buka fragmen menu2
            supportFragmentManager.beginTransaction().replace(R.id.frm_content, Menu_2Fragment())
                .commit()
        }
//        event img_menu3
        binding.imgMenu3.setOnClickListener {
            menu = "3"

            //        buar avriabel fragment
            val fragment = Menu_3Fragment()
//        buat variabel bundle
            val bundle = Bundle()
//        kirim parameter
            bundle.putString("Content3", "ini contoh fragment 3 lagi")
            fragment.arguments = bundle
            //            buka fragmen menu3
            supportFragmentManager.beginTransaction().replace(R.id.frm_content, fragment)
                .commit()

        }


//        buat method untuk tombol "back"
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
//                jika menu = "2"/ menu= "3"
                if (menu == "2" || menu == "3"){
//                    panggil fragment 1
                    openFragment1()
                }
//                jika menu = 21
                else if (menu == "21"){
                    binding.imgMenu2.performClick()
                }
                else{
//                    jika menu1 back mau close
                    finish()
                }
            }

        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

//buat fungsi untuk menu1

    fun openFragment1(){
        menu = "1"
        supportFragmentManager.beginTransaction().replace(R.id.frm_content, Menu1Fragment())
            .commit()
    }
}