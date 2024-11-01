package com.thoren.manganimu.core.ui.component

import PreviewTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.thoren.manganimu.core.ui.common.SpaceSize
import com.thoren.manganimu.core.ui.theme.typography

@Composable
fun BasicAnimeTile(
    title: String,
    imageUrl: String?,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val minWidthInDp = 120.dp
    val minHeightInDp = 180.dp

    Box(
        modifier = modifier
            .clickable { onClick?.invoke() }
            .defaultMinSize(minWidth = minWidthInDp, minHeight = minHeightInDp)
            .clip(shape = RoundedCornerShape(SpaceSize.small)),
        contentAlignment = Alignment.BottomCenter,
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(SpaceSize.small)),
            contentScale = ContentScale.FillBounds,
            model = imageUrl,
            contentDescription = null
        )
        Row(
            modifier = Modifier
                .matchParentSize()
                .align(alignment = Alignment.BottomCenter)
                .background(color = Color.Black.copy(alpha = 0.1f))
        ) {
            Text(
                text = title,
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 1,
                style = typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(alignment = Alignment.Bottom)
                    .padding(horizontal = SpaceSize.tiny)
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun BasicAnimeTilePreview() {
    PreviewTheme {
        BasicAnimeTile(
            title = "My hero academia",
            imageUrl = "https://cdn.myanimelist.net/images/anime/13/17405.jpg"
        )
    }
}