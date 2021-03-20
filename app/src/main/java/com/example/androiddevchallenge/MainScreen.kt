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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Calendar

@Composable
fun MainScreen() {
    Scaffold {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(40.dp))
            Highlight()
            Spacer(modifier = Modifier.height(80.dp))
            Next5Days()
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 640)
fun MainScreenPreview() {
    MyTheme {
        MainScreen()
    }
}

@Composable
fun Next5Days() {
    Column {
        ColumnHeading()
        val today = Calendar.getInstance()
        DayCard(weatherForDay = WeatherForDay(date = today))
        DayCard(weatherForDay = WeatherForDay(date = today.addDays(1)))
        DayCard(weatherForDay = WeatherForDay(date = today.addDays(2)))
        DayCard(weatherForDay = WeatherForDay(date = today.addDays(3)))
        DayCard(weatherForDay = WeatherForDay(date = today.addDays(4)))
    }
}

@Composable
fun ColumnHeading() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1.3f))
        // Text(
        //     modifier = Modifier.weight(1.3f),
        //     text = "Date",
        //     textAlign = TextAlign.Center
        // )
        ColumnHeadingText(
            modifier = Modifier.weight(2f),
            text = stringResource(R.string.morning)
        )
        ColumnHeadingText(
            modifier = Modifier.weight(2f),
            text = stringResource(R.string.afternoon)
        )
        ColumnHeadingText(
            modifier = Modifier.weight(2f),
            text = stringResource(R.string.evening)
        )
    }
}

@Composable
fun ColumnHeadingText(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
@Preview
fun ColumnHeadingPreview() {
    MyTheme {
        ColumnHeading()
    }
}

fun Calendar.addDays(days: Int): Calendar {
    val newCalendar = (this.clone() as Calendar)
    newCalendar.add(Calendar.DATE, days)
    return newCalendar
}
