package com.nnapps.countr.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HitOrMissButton(modifier: Modifier = Modifier, color: Long, text: String, onClickAction: () -> Unit) {

    Button(
        onClick = { onClickAction() },
        modifier = modifier
            .fillMaxWidth()
            .padding(PaddingValues(horizontal = 24.dp, vertical = 16.dp))
            .clip(RoundedCornerShape(15.dp)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(color), // Background color with reduced opacity
            disabledBackgroundColor = Color.Gray, // Background color when the button is disabled
            disabledContentColor = Color.DarkGray // Text color when the button is disabled
        ),
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
