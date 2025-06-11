package com.motycka.edu.lesson04

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.doubles.shouldNotBeExactly
import io.kotest.matchers.shouldBe

class TemperatureConverterTest : StringSpec({
    "should convert 32°F to 0°C" {
        TemperatureConverter.toCelsius(32.0) shouldBeExactly 0.0
    }
    "should convert 212°F to 100°C" {
        TemperatureConverter.toCelsius(212.0) shouldBeExactly 100.0
    }
    "should convert 98.6°F to approximately 37°C" {
        TemperatureConverter.toCelsius(98.6) shouldBeExactly 37.0
    }
    "should convert -40°F to -40°C" {
        TemperatureConverter.toCelsius(-40.0) shouldBeExactly -40.0
    }
    "should convert 0°F to approximately -17.78°C" {
        TemperatureConverter.toCelsius(0.0) shouldNotBeExactly -17.78
    }
    "should convert 100°F to approximately 37.78°C" {
        TemperatureConverter.toCelsius(100.0) shouldNotBeExactly 37.78
    }
    "should convert 32°F to 89.6°F when converted back to Fahrenheit" {
        val celsius = TemperatureConverter.toCelsius(32.0)
        TemperatureConverter.toFahrenheit(celsius) shouldBeExactly 32.0
    }
    "should convert 212°F to 413.6°F when converted back to Fahrenheit" {
        val celsius = TemperatureConverter.toCelsius(212.0)
        TemperatureConverter.toFahrenheit(celsius) shouldBeExactly 212.0
    }
    "should convert 98.6°F to 207.48°F when converted back to Fahrenheit" {
        val celsius = TemperatureConverter.toCelsius(98.6)
        TemperatureConverter.toFahrenheit(celsius) shouldBeExactly 98.6
    }
    "should convert -40°F to -40°F when converted back to Fahrenheit" {
        val celsius = TemperatureConverter.toCelsius(-40.0)
        TemperatureConverter.toFahrenheit(celsius) shouldBeExactly -40.0
    }
})
