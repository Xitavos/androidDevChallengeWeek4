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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun DayCard(weatherForDay: WeatherForDay) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(72.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Date(
                modifier = Modifier.weight(1.3f),
                date = weatherForDay.date
            )
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
            )
            WeatherEmojiAndTemperature(
                modifier = Modifier.weight(2f),
                weatherTypeAndEmoji = weatherForDay.weatherMap.getValue(Time.NINE_AM).weather/*,
                timeOfDay = stringResource(R.string.morning)*/
            )
            WeatherEmojiAndTemperature(
                modifier = Modifier.weight(2f),
                weatherTypeAndEmoji = weatherForDay.weatherMap.getValue(Time.THREE_PM).weather/*,
                timeOfDay = stringResource(R.string.afternoon)*/
            )
            WeatherEmojiAndTemperature(
                modifier = Modifier.weight(2f),
                weatherTypeAndEmoji = weatherForDay.weatherMap.getValue(Time.NINE_PM).weather/*,
                timeOfDay = stringResource(R.string.evening)*/
            )
        }
    }
}

@Composable
fun Date(
    modifier: Modifier = Modifier,
    date: Calendar
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = date.get(Calendar.DAY_OF_MONTH).toString(),
            fontSize = 25.sp
        )
        Text(
            text = SimpleDateFormat("MMM", Locale.getDefault())
                .format(date.time)
                .toUpperCase(Locale.ROOT)
        )
    }
}

@Composable
fun WeatherEmojiAndTemperature(
    modifier: Modifier = Modifier,
    weatherTypeAndEmoji: WeatherTypeAndEmoji//,
    //timeOfDay: String
) {
    Column(
        modifier = modifier
            .fillMaxHeight(),
        // .padding(top = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Text(
        //     text = timeOfDay,
        //     fontSize = 8.sp,
        //     fontWeight = FontWeight.Bold
        // )
        // Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = weatherTypeAndEmoji.emoji,
            fontSize = 40.sp
        )
    }
}

@Composable
@Preview
fun DayCardPreview() {
    MyTheme {
        DayCard(
            weatherForDay = WeatherForDay(
                date = Calendar.getInstance()
            )
        )
    }
}
