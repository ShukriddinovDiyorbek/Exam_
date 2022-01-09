package uz.pdp.listview1

import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.listview1.adapter.CustomAdapter
import uz.pdp.listview1.model.Member


class MainActivity : AppCompatActivity() {
    lateinit var recycler_view: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val members = preparedList()
        refreshAdapter(members)
    }
    fun initViews(){
        recycler_view = findViewById(R.id.recycler_view)
        recycler_view.layoutManager = GridLayoutManager(this, 1)
    }
    fun refreshAdapter(members: List<Member>){
        val adapter = CustomAdapter(members)
        recycler_view.adapter = adapter
    }
    fun preparedList(): List<Member>{
        val members = ArrayList<Member>()
        for (i in 0..30){
            members.add(Member(R.drawable.google, "Google", "Software company"))
        }
        return members
    }

}