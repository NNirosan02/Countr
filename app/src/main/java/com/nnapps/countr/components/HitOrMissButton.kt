package com.nnapps.countr.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HitOrMissButton(modifier: Modifier = Modifier, text: String, onClickAction: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClickAction()
            }
            .padding(PaddingValues(horizontal = 60.dp, vertical = 16.dp))
            .clip(RoundedCornerShape(15.dp)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = text,
            fontSize = 26.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
