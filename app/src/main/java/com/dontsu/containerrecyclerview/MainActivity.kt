package com.dontsu.containerrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity(), DataClickInterface {

    init {
        //Timber initialize
        Timber.plant(Timber.DebugTree())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.apply {
            val data = loadData()
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListAdapter(data)
        }
    }

    private fun loadData() : MutableList<Memo> {
        //컬렉션 생성
        val data: MutableList<Memo> = mutableListOf()
        for (no in 1..100) {
            val title = "무더위 물러가라 ${no + 1}"
            val date = System.currentTimeMillis()
            var memo = Memo(no, title, date)
            data.add(memo)
        }

        return data
    }

    override fun onClickMemo(title: String) {
        Toast.makeText(this, "선택된 아이템 = $title", Toast.LENGTH_SHORT).show()
    }

}
