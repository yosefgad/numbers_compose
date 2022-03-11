package org.yosef.giniapp.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import org.yosef.giniapp.navigation.ScreensViews

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember { //scale effect for animation
        Animatable(0f)
    }
    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 0.9f, animationSpec = tween(
            durationMillis = 800,
            easing = {
                OvershootInterpolator(8f)
                    .getInterpolation(it)
            }
        ))
        //delay few seconds and go to next view
        delay(2000)
        navController.navigate(ScreensViews.NumbersScreen.name)
    })
    Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(120.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Loading...")
        }
    }

}