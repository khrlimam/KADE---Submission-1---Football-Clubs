package footballclub.submissions.dicoding.app.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import footballclub.submissions.dicoding.app.footballclub.adapters.InlineImageAndLabelRecyclerViewAdapter
import footballclub.submissions.dicoding.app.footballclub.data.FootBallClub
import footballclub.submissions.dicoding.app.footballclub.layouts.MyRecyclerView
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class FootballClubs : AppCompatActivity() {

  companion object {
    const val DESCRIPTION_KEY: String = "DESCRIPTION_KEY"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val adapter = InlineImageAndLabelRecyclerViewAdapter(getData(), viewFootballClubDetail())
    MyRecyclerView(adapter).setContentView(this)
  }

  private fun viewFootballClubDetail(): (FootBallClub) -> Unit {
    return {
      startActivity<FootballClubDescriptionActivity>(
          DESCRIPTION_KEY to it)
    }
  }

  private fun getData(): MutableList<FootBallClub> {
    val clubNames = resources.getStringArray(R.array.club_name)
    val clubLogos = resources.obtainTypedArray(R.array.club_image)
    val clubDescriptions = resources.getStringArray(R.array.club_description)

    val listClubData = clubNames.withIndex().map {
      FootBallClub(it.value,
          clubDescriptions[it.index],
          clubLogos.getResourceId(it.index, 0))
    }.toMutableList()
    clubLogos.recycle()
    return listClubData
  }
}
