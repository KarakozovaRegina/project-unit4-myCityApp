package krv.fit.bstu.project_unit4_mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Cafe (
    val id: Int,
    @StringRes val name: Int,
    @StringRes val details: Int,
    @DrawableRes val img: Int
)