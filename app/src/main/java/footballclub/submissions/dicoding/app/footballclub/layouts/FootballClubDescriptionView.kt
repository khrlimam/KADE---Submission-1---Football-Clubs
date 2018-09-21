package footballclub.submissions.dicoding.app.footballclub.layouts

import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import footballclub.submissions.dicoding.app.footballclub.R
import footballclub.submissions.dicoding.app.footballclub.data.FootBallClub
import org.jetbrains.anko.*

class FootballClubDescriptionView(val data: FootBallClub) : AnkoComponent<AppCompatActivity> {
  override fun createView(ui: AnkoContext<AppCompatActivity>): View = with(ui) {
    return scrollView {
      lparams(width = matchParent, height = matchParent)

      verticalLayout {
        frameLayout {
          imageView {
            scaleType = ImageView.ScaleType.CENTER_CROP
            Glide.with(context).load(data.logo).into(this)
          }.lparams(width = matchParent, height = dip(350))

          textView(data.name) {
            textSize = sp(9).toFloat()
            padding = dip(10)
            backgroundColor = ContextCompat.getColor(context, R.color.transparent_grey)
            textColor = ContextCompat.getColor(context, R.color.white)
          }.lparams(width = wrapContent, height = wrapContent) {
            gravity = Gravity.BOTTOM
          }
        }

        textView(data.description) {
          padding = dip(10)
          textSize = sp(7).toFloat()
          textColor = ContextCompat.getColor(context, R.color.black)
        }

      }
    }
  }
}