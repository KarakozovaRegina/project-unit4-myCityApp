package krv.fit.bstu.project_unit4_mycityapp.ui
import androidx.collection.objectFloatMapOf
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import krv.fit.bstu.project_unit4_mycityapp.R
import krv.fit.bstu.project_unit4_mycityapp.data.CafesObject
import krv.fit.bstu.project_unit4_mycityapp.model.Cafe
import krv.fit.bstu.project_unit4_mycityapp.utils.CafesContentType

@Composable
fun CafeApp(
    windowSize: WindowWidthSizeClass,
) {

    val viewModel: CafeViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> CafesContentType.ListOnly

        WindowWidthSizeClass.Expanded -> CafesContentType.ListAndDetail
        else -> CafesContentType.ListOnly
    }

    Scaffold(
        topBar = {
            CafeAppBar(
                {
                    viewModel.navigateToListScreen()
                },
                isShowingListScreen = uiState.showDetailsPage
            )
                 },
    ) { innerPadding ->

        if(contentType == CafesContentType.ListAndDetail){

            CafeListAndDetails(
                cafes = uiState.cafesList,
                selectedSport = uiState.currentItem,
                onClick = {
                    viewModel.updateCurrentSport(it)
                },
                onBackPressed = {  viewModel.navigateToListScreen() },
                contentPadding = innerPadding,
                modifier = Modifier.fillMaxWidth()
            )

        }else{
            if(!uiState.showDetailsPage){
                CafeList(
                    cafes = uiState.cafesList,
                    onClick = {
                        viewModel.updateCurrentSport(it)
                        viewModel.navigateToDetailsScreen()
                    },
                    contentPadding = innerPadding,
                    modifier = Modifier.fillMaxWidth()
                )
            }else{
                CafeDetails(
                    selectedSport = uiState.currentItem,
                    contentPadding = innerPadding,
                    onBackPressed = {
                        viewModel.navigateToListScreen()
                    },
                    modifier = Modifier
                )
            }

        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CafeAppBar(
    onBackButtonClick: () -> Unit,
    isShowingListScreen: Boolean,
    modifier: Modifier = Modifier
) {

    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_bar),
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            if(isShowingListScreen){
                IconButton(
                    onClick = onBackButtonClick
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }else {
                Box {}
            }
        },
        modifier = modifier,
    )
}

