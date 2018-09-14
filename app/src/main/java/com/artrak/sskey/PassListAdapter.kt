package com.artrak.sskey

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.artrak.sskey.newOld.Password

// instruction - https://github.com/betranthanh/android-KotlinListView/blob/master/README.md

class PassListAdapter(private var activity: Activity, private var items: ArrayList<Password>): BaseAdapter() {

    private class ViewHolder(row: View?){
        var pass_id: TextView? = null
        var url: TextView? = null
        var title: TextView? = null
        var login: TextView? = null
        var password: TextView? = null
        var comment: TextView? = null

        init {
            this.pass_id = row?.findViewById(R.id.passIdValue)
            this.url = row?.findViewById(R.id.urlValue)
            this.title = row?.findViewById(R.id.titleValue)
            this.login = row?.findViewById(R.id.loginValue)
            this.password = row?.findViewById(R.id.passwordValue)
            this.comment = row?.findViewById(R.id.commentValue)

        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.item_list_manager_pass, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var userPass = items[position]
        viewHolder.pass_id?.text = userPass.pass_id
        viewHolder.url?.text = userPass.url
        viewHolder.title?.text = userPass.title
        viewHolder.login?.text = userPass.login
        viewHolder.password?.text = userPass.password
        viewHolder.comment?.text = userPass.comment

        return view as View
    }

    override fun getItem(i: Int): Password {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}