package com.example.dishcraft

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun SplashScreen(onAnimationFinished: () -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))

    // تشغيل الأنيميشن
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = 1, // مرة واحدة
        isPlaying = true,
        restartOnPlay = false,
        speed = 1.0f,
        // عند انتهاء الأنيميشن
        // onFinished = { onAnimationFinished() }
    )

    LaunchedEffect(progress) {
        if (progress == 1f) {
            onAnimationFinished()
        }
    }

    LottieAnimation(
        composition = composition,
        iterations = 1, // مرة واحدة
        modifier = Modifier.fillMaxSize()
    )
}
