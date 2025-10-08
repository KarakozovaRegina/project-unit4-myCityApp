package krv.fit.bstu.project_unit4_mycityapp.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import krv.fit.bstu.project_unit4_mycityapp.data.CafesObject
import krv.fit.bstu.project_unit4_mycityapp.model.Cafe

class CafeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        CafesUiState(
            cafesList = CafesObject.getCafes(),
            currentItem = CafesObject.getCafes().getOrElse(0) {
                CafesObject.defaultCafe
            }
        )
    )

    val uiState: StateFlow<CafesUiState> = _uiState

    fun updateCurrentSport(selectedCafe: Cafe) {
        _uiState.update {
            it.copy(currentItem = selectedCafe)
        }
    }


    // navigation with using states
    fun navigateToListScreen(){
        _uiState.update {
            it.copy(showDetailsPage = false)
        }

    }
    fun navigateToDetailsScreen(){
        _uiState.update {
            it.copy(showDetailsPage = true)
        }
    }
}

data class CafesUiState(
    val cafesList: List<Cafe> = emptyList(),
    val showDetailsPage: Boolean = false,
    val currentItem: Cafe = CafesObject.defaultCafe
    )