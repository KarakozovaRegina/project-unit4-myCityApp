package krv.fit.bstu.project_unit4_mycityapp.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
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
import krv.fit.bstu.project_unit4_mycityapp.data.CafesObject
import krv.fit.bstu.project_unit4_mycityapp.model.Cafe
import krv.fit.bstu.project_unit4_mycityapp.ui.theme.Projectunit4myCityAppTheme


@Composable
fun CafeList(
    cafes:List<Cafe>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium)),
    ) {
        items(cafes, key = { cafe -> cafe.id}){ cafe ->
            CafeListItem(
                cafe = cafe
            )
        }
    }
}

@Composable
private fun CafeListImageItem(cafe: Cafe, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(cafe.img),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillHeight
        )
    }
}

@Composable
private fun CafeListItem(cafe: Cafe, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.padding_medium))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ){
            CafeListImageItem(
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height)),
                cafe = cafe
            )
            Column(
                modifier = Modifier.weight(1f)
                    .fillMaxHeight(),
               horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(cafe.name),
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}


@Preview
@Composable
fun ShowListCafe() {
    Projectunit4myCityAppTheme {
        Surface {
            CafeList(
                cafes = CafesObject.getCafes(),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
            )
        }
    }
}