/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Highlight() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Wellington", fontSize = 25.sp, textAlign = TextAlign.Center)
        Text(text = "☀️", fontSize = 300.sp, textAlign = TextAlign.Center)
        Text(text = "It's 18ºC", fontSize = 50.sp, textAlign = TextAlign.Center)
    }

    // ConstraintLayout(
    //     modifier = Modifier.fillMaxSize()
    // ) {
    //     val (location, emoji, temperature, arrowIcon) = createRefs()
    //
    //     Text(
    //         modifier = Modifier.constrainAs(location) {
    //             top.linkTo(parent.top, 20.dp)
    //             start.linkTo(parent.start)
    //             end.linkTo(parent.end)
    //         },
    //         text = "Wellington",
    //         fontSize = 25.sp
    //     )
    //     Text(
    //         modifier = Modifier.constrainAs(emoji) {
    //             top.linkTo(location.bottom)
    //             start.linkTo(parent.start)
    //             end.linkTo(parent.end)
    //         },
    //         text = "☀️",
    //         fontSize = 250.sp
    //     )
    //     Text(
    //         modifier = Modifier.constrainAs(temperature) {
    //             top.linkTo(emoji.bottom)
    //             start.linkTo(parent.start)
    //             end.linkTo(parent.end)
    //         },
    //         text = "It's 18ºC",
    //         fontSize = 50.sp
    //     )
    //     Text(
    //         modifier = Modifier.constrainAs(arrowIcon) {
    //             bottom.linkTo(parent.bottom)
    //             start.linkTo(parent.start)
    //             end.linkTo(parent.end)
    //         },
    //         text = "v",
    //         fontSize = 50.sp
    //     )
    // }
}

@Composable
@Preview(widthDp = 360, heightDp = 640)
fun HighlightPreview() {
    MyTheme {
        Highlight()
    }
}
