package footballclub.submissions.dicoding.app.footballclub.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class FootBallClub(val name: String, val description: String, val logo: Int) : Parcelable