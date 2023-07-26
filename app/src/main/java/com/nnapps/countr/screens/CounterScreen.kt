package com.nnapps.countr.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nnapps.countr.R
import com.nnapps.countr.components.HitOrMissButton

@Composable
fun CounterScreen(viewModel: CountrViewModel) {
    val hitCount by viewModel.hitCount.observeAsState(initial = 0)
    val totalCount by viewModel.totalCount.observeAsState(initial = 0)

    val isSystemInDarkTheme = isSystemInDarkTheme()
    val onSurfaceVariant = MaterialTheme.colorScheme.onSurfaceVariant
    val trackColor = if (isSystemInDarkTheme) {
        onSurfaceVariant.copy(alpha = 0.12f)
    } else {
        onSurfaceVariant.copy(alpha = 0.24f)
    }

    val progress = if (totalCount != 0) {
        hitCount.toFloat() / totalCount.toFloat()
    } else {
        0f
    }
    Box(
        modifier = Modifier
            .size(250.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(200.dp),
            progress = progress.coerceIn(0f, 1f), // Ensure progress is within valid range
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            strokeWidth = 12.dp,
            strokeCap = StrokeCap.Round,
            trackColor = trackColor
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.txt_score),
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.25.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            )
            Text(
                text = "$hitCount",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.25.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Text(
                text = buildString {
                    append(stringResource(R.string.txt_total))
                    append(totalCount)
                },
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.25.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
    Buttons()
}

@Composable
fun Buttons(viewModel: CountrViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingValues(bottom = 20.dp)),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HitOrMissButton(
            text = stringResource(R.string.txt_reset),
                color = 0xFF000DFF
        ) { viewModel.onResetButtonClicked() }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            HitOrMissButton(
                text = stringResource(R.string.txt_hit),
                color = 0xFF006110,
                modifier = Modifier
                    .weight(1f)
            ) { viewModel.onHitButtonClicked() }
            HitOrMissButton(
                text = stringResource(R.string.txt_miss),
                color = 0xFFFF0000,
                modifier = Modifier
                    .weight(1f)
            ) { viewModel.onMissButtonClicked() }
        }
    }
}
