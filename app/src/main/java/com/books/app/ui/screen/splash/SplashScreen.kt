package com.books.app.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.books.app.R
import com.books.app.ui.dialog.BooksAlertDialog
import com.books.app.ui.resources.Georgia
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources.SplashScreenTitleColor
import com.books.app.ui.resources._12_Dp
import com.books.app.ui.resources._24_Dp
import com.books.app.ui.resources._25_Sp
import com.books.app.ui.resources._26_Sp
import com.books.app.ui.resources._52_Sp
import com.books.app.ui.screen.splash.SplashScreenViewModel.SplashUiState.Error
import com.books.app.ui.screen.splash.SplashScreenViewModel.SplashUiState.Loaded

@Composable
fun SplashScreen(
    onAppReady: () -> Unit,
    onConfirmAlertDialog: () -> Unit,
    viewModel: SplashScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_back),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.splash_front),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontFamily = Georgia,
                fontWeight = FontWeight.Bold,
                fontSize = _52_Sp,
                lineHeight = _52_Sp,
                color = SplashScreenTitleColor,
            )
            Text(
                text = stringResource(R.string.splash_screen_description),
                fontFamily = NunitoSans,
                fontWeight = FontWeight.Bold,
                fontSize = _25_Sp,
                color = Color.White.copy(alpha = 0.8f),
                lineHeight = _26_Sp,
                modifier = Modifier
                    .padding(top = _12_Dp)
            )

            LinearProgressIndicator(
                modifier = Modifier
                    .padding(top = _24_Dp)
            )
        }

        when (state) {
            Error -> {
                BooksAlertDialog(
                    title = stringResource(R.string.default_error_title),
                    message = stringResource(R.string.default_error_message_text),
                    onDismiss = onConfirmAlertDialog,
                    onConfirm = onConfirmAlertDialog
                )
            }
            Loaded -> onAppReady()
            else -> {
                //Loading state, do nothing
            }
        }
    }
}

@Preview
@Composable
private fun Preview_SplashScreen() {
    SplashScreen(
        onAppReady = {},
        onConfirmAlertDialog = {

        }
    )
}