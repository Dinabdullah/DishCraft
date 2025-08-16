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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.LightGray, // top color
                        colorResource(id = R.color.red_pink_main) // bottom color
                    )
                )
            )
            .padding(dimensionResource(id = R.dimen.dp_16)),
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
                    .padding(dimensionResource(id = R.dimen.dp_24)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Box {
                    Image(
                        painter = painterResource(id = screen.imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(id = R.dimen.dp_300))
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_16)))
                    )
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_16)))
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Black.copy(alpha = 0.3f),
                                        Color.DarkGray.copy(alpha = 0.3f)
                                    )
                                )
                            )
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(id = screen.title),
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                        fontSize = dimensionResource(id = R.dimen.sp_44).value.sp,
                        color = Color.DarkGray,
//                        style = TextStyle(
//                            shadow = Shadow(
//                                color = colorResource(id = R.color.red_pink_main),
//                                offset = Offset(4f, 4f),
//                                blurRadius = 8f
//                            )
//                        )
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dp_8)))
                    Text(
                        text = stringResource(id = screen.description),
                        fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                        fontWeight = FontWeight.Bold,
                        lineHeight = dimensionResource(id = R.dimen.sp_32).value.sp,
                        fontSize = dimensionResource(id = R.dimen.sp_32).value.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,

                    )
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.dp_16))
        ) {
            repeat(screens.size) { index ->
                val color =
                    if (pagerState.currentPage == index) colorResource(id = R.color.red_pink_main) else Color.Gray
                Box(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.dp_14))
                        .padding(dimensionResource(id = R.dimen.dp_4))
                        .background(color, shape = CircleShape)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen.dp_16))
                .padding(bottom = dimensionResource(id = R.dimen.dp_44)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = { scope.launch { pagerState.scrollToPage(screens.size - 1) } }) {
                Text(
                    stringResource(R.string.skip),
                    color = Color.DarkGray,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = dimensionResource(id = R.dimen.sp_16).value.sp,
                    fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
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
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                )
            ) {
                Text(
                    if (pagerState.currentPage == screens.size - 1) stringResource(R.string.get_started) else stringResource(
                        R.string.next
                    ),
                    fontFamily = FontFamily(Font(R.font.league_spartan_variable)),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
