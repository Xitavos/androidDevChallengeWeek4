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

import java.util.Calendar
import kotlin.random.Random

val weatherTypeAndEmojis = listOf(
    WeatherTypeAndEmoji("Clear", "☀️"),
    WeatherTypeAndEmoji("Partly cloudy", "🌤"),
    WeatherTypeAndEmoji("Cloudy", "☁️️"),
    WeatherTypeAndEmoji("Showers", "🌦️"),
    WeatherTypeAndEmoji("Rain", "🌧"),
    WeatherTypeAndEmoji("Thunderstorm", "🌩"),
    WeatherTypeAndEmoji("Wind", "🌬"),
    WeatherTypeAndEmoji("Fog", "🌫"),
    WeatherTypeAndEmoji("Snow", "🌨"),
)

enum class Time {
    THREE_AM,
    SIX_AM,
    NINE_AM,
    TWELVE_PM,
    THREE_PM,
    SIX_PM,
    NINE_PM,
    TWELVE_AM
}

data class WeatherTypeAndEmoji(
    val weatherType: String,
    val emoji: String
)

data class Weather(
    val weather: WeatherTypeAndEmoji = weatherTypeAndEmojis.random(),
    val temperature: Int = Random.nextInt(-10, 41),
    val windSpeed: Int = Random.nextInt(0, 51)
)

data class WeatherForDay(
    val date: Calendar,
    val weatherMap: Map<Time, Weather> = Time.values().map { Pair(it, Weather()) }.toMap()
)
