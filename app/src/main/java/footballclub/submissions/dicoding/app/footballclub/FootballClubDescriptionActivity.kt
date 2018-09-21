package footballclub.submissions.dicoding.app.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import footballclub.submissions.dicoding.app.footballclub.layouts.FootballClubDescriptionView
import org.jetbrains.anko.setContentView

class FootballClubDescriptionActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    FootballClubDescriptionView(intent
        .getParcelableExtra(FootballClubs.DESCRIPTION_KEY))
        .setContentView(this)
  }
}