package com.motycka.edu.lesson03.model

/*
 Implement Cuboid class that implements Shape3D interface.
    - It should have a constructor that takes three parameters for width, height, and depth.
    - It should override all methods from Shape3D interface.
 */

class Cuboid(private val width: Double, private val height: Double, private val depth: Double) : Shape3D {
    override fun volume(): Double = width * height * depth
    override fun surfaceArea(): Double = 2 * (width * height + width * depth + height * depth)
    override fun toString(): String = "Cuboid(width=$width, height=$height, depth=$depth, volume=${volume()}, surfaceArea=${surfaceArea()})"
}