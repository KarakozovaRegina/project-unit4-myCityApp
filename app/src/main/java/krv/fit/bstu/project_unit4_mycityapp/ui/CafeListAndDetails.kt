package krv.fit.bstu.project_unit4_mycityapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import krv.fit.bstu.project_unit4_mycityapp.R
import krv.fit.bstu.project_unit4_mycityapp.model.Cafe


@Composable
fun CafeListAndDetails(
    cafes:List<Cafe>,
    onClick: (Cafe) -> Unit,
    selectedSport: Cafe,
    onBackPressed: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier
) {
    Box {

        Row(
            modifier = modifier
        ) {
            CafeList(
                cafes = cafes,
                onClick = onClick,
                contentPadding = contentPadding,
                modifier = modifier
                    .weight(2f)
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium))
            )
            CafeDetails(
                selectedSport = selectedSport,
                contentPadding = PaddingValues(
                    top = contentPadding.calculateTopPadding(),
                ),
                onBackPressed = onBackPressed,
                modifier = modifier.weight(3f)
            )
        }
    }
}