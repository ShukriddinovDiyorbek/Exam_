package uz.pdp.listview1

import android.content.Context
import android.os.Bundle
import android.telephony.TelephonyManager
import android.telephony.TelephonyManager.*
import android.util.DisplayMetrics
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.listview1.adapter.CustomAdapter
import uz.pdp.listview1.model.Member
import java.util.*
import java.util.Objects.requireNonNull
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    lateinit var recycler_view: RecyclerView
    lateinit var adapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val members = preparedList()
        refreshAdapter(members)

    }

    override fun onResume() {
        super.onResume()
        if (adapter.isEnd) {
            adapter.isEnd = false
            refreshAdapter(preparedList())
            Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
        }
    }
    fun initViews(){
        recycler_view = findViewById(R.id.recycler_view)

        //Tablet or smatphone
        val manager =
            applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (requireNonNull(manager).phoneType === PHONE_TYPE_NONE) {
            recycler_view.layoutManager = GridLayoutManager(this, 3)
        } else {
            recycler_view.layoutManager = GridLayoutManager(this, 1)
        }
    }
    fun refreshAdapter(members: List<Member>){
        adapter = CustomAdapter(members)
        recycler_view.adapter = adapter
    }
    fun preparedList(): List<Member>{
        val members = ArrayList<Member>()
        for (i in 0..30){
            if(i % 7 == 0) {
                members.add(Member(R.drawable.img1, "Ssushi", "Tashkent", "$5", 1.5))
            }
            if(i % 7 == 1) {
                members.add(Member(R.drawable.img2, "Fire Hyper", "Samarkand", "$4.3", 2.5
                ))
            }
            if(i % 7 == 2) {
                members.add(Member(R.drawable.img3, "Deli Turbo", "Bukhara", "$2.4", 4.9))
            }
            if(i % 7 == 3) {
                members.add(Member(R.drawable.img4, "Staekhouse", "Jizzakh", "$10", 2.7))
            }
            if(i % 7 == 4) {
                members.add(Member(R.drawable.img5, "Deli Hyper", "Navoi", "$2.3", 4.5))
            }
            if(i % 7 == 5) {
                members.add(Member(R.drawable.img6, "Dinner steak", "Fergana", "$2.0", 5.0))
            }
            if(i % 7 == 6) {
                members.add(Member(R.drawable.img1, "Lagman", "Namangan", "$4", 3.5))
            }
        }
        return members
    }

}