package footballclub.submissions.dicoding.app.footballclub.layouts

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.verticalLayout

class MyRecyclerView(private val adapter_: RecyclerView.Adapter<*>) : AnkoComponent<AppCompatActivity> {
  override fun createView(ui: AnkoContext<AppCompatActivity>): View = with(ui) {
    return verticalLayout {
      lparams(width = matchParent, height = matchParent)
      recyclerView {
        adapter = adapter_
        layoutManager = LinearLayoutManager(context)
      }.lparams(width = matchParent, height = matchParent)
    }
  }

}