package footballclub.submissions.dicoding.app.footballclub.layouts

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import footballclub.submissions.dicoding.app.footballclub.R
import org.jetbrains.anko.*

class InlineImageAndLabelItemView : AnkoComponent<ViewGroup> {
  override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
    return linearLayout {
      lparams(matchParent, wrapContent)
      orientation = LinearLayout.HORIZONTAL
      padding = dip(16)

      imageView(R.drawable.ic_launcher_background) {
        id = ivImage
      }.lparams(width = dip(50), height = dip(50))

      textView("Image Label") {
        id = lblName
        textColor = resources.getColor(R.color.black)
      }.lparams(width = wrapContent, height = wrapContent) {
        margin = dip(10)
        gravity = Gravity.CENTER_VERTICAL
      }

    }
  }

  companion object {
    const val ivImage = 0
    const val lblName = 1
  }

}