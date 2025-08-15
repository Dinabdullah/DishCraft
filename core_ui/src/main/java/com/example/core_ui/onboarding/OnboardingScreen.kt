package com.example.core_ui.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_ui.R

@Composable
fun OnboardingScreen(
    screens: List<OnboardingComponent>,
    currentPage: Int,
    onNext: () -> Unit,
    onSkip: () -> Unit,
    onFinish: () -> Unit
) {
    val screen = screens[currentPage]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // الصورة
        Image(
            painter = painterResource(id = screen.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        // النصوص
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id =screen.title ) ,
                fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                fontWeight = FontWeight.Bold,
                fontSize = 44.sp,
                color = colorResource(id = R.color.red_pink_main)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id= screen.description),
                fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                fontWeight = FontWeight.Bold,
                lineHeight = dimensionResource(id = R.dimen.sp_32).value.sp,
                fontSize = 32.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }

        // indicators (dots)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            screens.forEachIndexed { index, _ ->
                val color =
                    if (index == currentPage) colorResource(id = R.color.red_pink_main) else Color.Gray
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .padding(4.dp)
                        .background(color, shape = CircleShape)
                )
            }
        }

        // الأزرار
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            if (currentPage != 2) {
                TextButton(onClick = { onSkip() }) {
                    Text(
                        "Skip",
                        color = colorResource(id = R.color.red_pink_main),
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                        fontWeight = FontWeight.Bold
                    )
                }
            } else {
                TextButton(onClick = { }) {
                    Text(
                        "Skip",
                        color = Color.Transparent,
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                        fontWeight = FontWeight.ExtraBold

                    )
                }
            }

            Button(
                onClick = {
                    if (currentPage == screens.size - 1) onFinish()
                    else onNext()
                }, colors = ButtonColors(
                    containerColor = colorResource(id = R.color.red_pink_main),
                    contentColor = Color.White,
                    disabledContainerColor = colorResource(id = R.color.red_pink_main),
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    if (currentPage == screens.size - 1) "Get Started" else "Next",
                    fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                    fontWeight = FontWeight.Bold                )
            }
        }
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen(
        screens = listOf(
            OnboardingComponent.Screen1,
            OnboardingComponent.Screen2,
            OnboardingComponent.Screen3
        ),
        currentPage = 0,
        onNext = {},
        onSkip = {},
        onFinish = {}
    )
}
