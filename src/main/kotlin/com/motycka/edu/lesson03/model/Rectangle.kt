package com.motycka.edu.lesson03.model

/*
 Implement Rectangle class that implements Shape2D and Quadrilateral interfaces.
    - It should have a constructor that takes two parameters for width and length.
    - It should override all methods from Shape2D and Quadrilateral interfaces
 */
open class Rectangle(
    override val width: Double,
    override val length: Double
) : Shape2D, Quadrilateral {
    override fun area(): Double = width * length
    override fun perimeter(): Double = 2 * (width + length)
    override fun to3D(depth: Double): Shape3D = Cuboid(width, length, depth)
}