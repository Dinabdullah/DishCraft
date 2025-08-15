package com.example.core_ui.onboarding

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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_ui.R
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreenHorizontal(
    screens: List<OnboardingComponent>,
    onFinish: () -> Unit
) {
    val pagerState = rememberPagerState(
        pageCount = { screens.size }
    )
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            val screen = screens[page]

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = screen.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(id = screen.title),
                        fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 44.sp,
                        color = colorResource(id = R.color.red_pink_main)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = screen.description),
                        fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                        fontWeight = FontWeight.Bold,
                        lineHeight = dimensionResource(id = R.dimen.sp_32).value.sp,
                        fontSize = 32.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            repeat(screens.size) { index ->
                val color =
                    if (pagerState.currentPage == index) colorResource(id = R.color.red_pink_main) else Color.Gray
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .padding(4.dp)
                        .background(color, shape = CircleShape)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 44.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = { scope.launch { pagerState.scrollToPage(screens.size - 1) } }) {
                Text(
                    "Skip",
                    color = colorResource(id = R.color.red_pink_main),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = {
                    scope.launch {
                        if (pagerState.currentPage == screens.size - 1) onFinish()
                        else pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.red_pink_main),
                    contentColor = Color.White
                )
            ) {
                Text(
                    if (pagerState.currentPage == screens.size - 1) "Get Started" else "Next",
                    fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
