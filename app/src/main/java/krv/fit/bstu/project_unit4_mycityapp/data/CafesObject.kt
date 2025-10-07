package krv.fit.bstu.project_unit4_mycityapp.data

import krv.fit.bstu.project_unit4_mycityapp.R
import krv.fit.bstu.project_unit4_mycityapp.model.Cafe

object CafesObject {

    fun getCafes(): List<Cafe> {
        return listOf(
            Cafe(
                id = 1,
                name =  R.string.cafe_1,
                details = R.string.details,
                img = R.drawable.koriko_cafe_1
            ),
            Cafe(
                id = 2,
                name =  R.string.cafe_2,
                details = R.string.details,
                img = R.drawable._0_g
            ),
            Cafe(
                id = 3,
                name =  R.string.cafe_3,
                details = R.string.details,
                img = R.drawable.bean_brothers
            ),
            Cafe(
                id = 4,
                name =  R.string.cafe_4,
                details = R.string.details,
                img = R.drawable.plant
            ),
            Cafe(
                id = 5,
                name =  R.string.cafe_5,
                details = R.string.details,
                img = R.drawable.poem
            ),
            Cafe(
                id = 6,
                name =  R.string.cafe_6,
                details = R.string.details,
                img = R.drawable.jeontong_dawon
            ),
            Cafe(
                id = 7,
                name =  R.string.cafe_7,
                details = R.string.details,
                img = R.drawable.books_cooks
            )
        )
    }
}