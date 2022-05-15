package org.yosef.app.screens.numbers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.yosef.app.data.DataOrException
import org.yosef.app.models.Number
import org.yosef.app.models.Numbers

@Composable
fun NumbersScreen(
    navController: NavController,
    viewModel: NumberScreenViewModel = hiltViewModel()
) {
    val numbersData = produceState<DataOrException<Numbers, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = viewModel.getNumbersData()
    }.value

    if (numbersData.loading == true) {
        CircularProgressIndicator()
    } else if (numbersData.data != null) {
        showNumbers(data = numbersData.data!!)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun showNumbers(data: Numbers) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color.White
        ) {
            val numList = mutableListOf<Int>()
            Column() {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(3)
                ) {

                    items(data.numbers) { item: Number ->
                        var isDouble = false
                        data.numbers.forEach { newNumber ->
                            if (item.number == newNumber.number * -1 && item.number != 0) {
//                                Log.d("TAG", "showNumbers DOUBLE: --> ${number.number}")
                                DoubleItem(num = item.number)
                                isDouble = true
                                return@forEach
                            }
                        }
                        if (!isDouble) {
                            NumberItem(item.number)
                        }

                    }
                }

            }
        }

    }
}


@Composable
fun DoubleItem(num: Int) {
    Surface(
        modifier = Modifier.padding(3.dp)
            .height(120.dp), color = MaterialTheme.colors.secondaryVariant
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "$num")
        }

    }
}

@Composable
fun NumberItem(num: Int) {
    Surface(
        modifier = Modifier.padding(3.dp)
            .height(100.dp),
        color = MaterialTheme.colors.secondary
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "$num")
        }
    }
}

