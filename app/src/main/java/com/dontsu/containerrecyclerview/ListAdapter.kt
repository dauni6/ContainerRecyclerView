package com.dontsu.containerrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_item.view.*
import java.text.SimpleDateFormat

class ListAdapter(var listData : MutableList<Memo>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return listData.size
    }

    //프로그램을 실행하면 한 화면에보이는 개수만큼 안드로이드가 호출함.
    //예를들어 한 화면에 10개가 보이면 10번 호출을 한다고 생각하면 된다. 단, 같은 형태이면 onCreateViewHolder는 한 번 만 만들어지고
    //형태를 재사용 한다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_item, parent, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ListViewHolder -> {
                val memo = listData[position]
                holder.setMemo(memo)
            }
        }
    }

    class ListViewHolder(view : View): RecyclerView.ViewHolder(view) {

        /*init {
               //따로 인터페이스 만들고 impl 만드는거 보다, 그냥 init에 밑에처럼하는게 제일 간단!
            itemView.setOnClickListener {
                Toast.makeText(itemView?.context,"클릭된 아이템 = ${itemView.title.text}", Toast.LENGTH_SHORT).show()
            }
        }*/

        fun setMemo(memo: Memo) {
            itemView.number.text = "${memo.no}"
            itemView.title.text = memo.title
            val sdf = SimpleDateFormat("yyyy/MM/dd")
            val fDate = sdf.format(memo.timestamp)
            itemView.date.text = fDate
            itemView.title.setOnClickListener { DataClickImpl(itemView.title.text.toString(), itemView.context as MainActivity) }

        }

    }

}
