package krv.fit.bstu.project_unit4_mycityapp.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import krv.fit.bstu.project_unit4_mycityapp.R
import krv.fit.bstu.project_unit4_mycityapp.model.Cafe
import krv.fit.bstu.project_unit4_mycityapp.ui.theme.Projectunit4myCityAppTheme

@Composable
fun CafeDetails(
    selectedSport: Cafe,
    onBackPressed: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier
) {
    val scrollState = rememberScrollState()

    BackHandler {
        onBackPressed()
    }

    Box(
        modifier = modifier.fillMaxWidth()
            .verticalScroll(state = scrollState)
    ){
        Column(
modifier.fillMaxWidth()
        ) {
            Box() {
                Image(
                    modifier = modifier.fillMaxWidth(),
                    painter = painterResource(selectedSport.img),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth,
                )
            }

                Text(
                    text = stringResource(selectedSport.name),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.padding_small), vertical = dimensionResource(R.dimen.padding_medium))
                    )

                Text(
                    text = stringResource(selectedSport.details),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.padding_small))
                        .padding(bottom = dimensionResource(R.dimen.padding_small))
                )

        }
    }
}

/*
@Preview
@Composable
fun ShowCafeDetails() {
    Projectunit4myCityAppTheme {
        Surface {
            CafeDetails(
                cafe = Cafe(
                    id = 4,
                    name = R.string.cafe_4,
                    details = R.string.details,
                    img = R.drawable.plant
                ),
                //contentPadding = innerPadding,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}*/