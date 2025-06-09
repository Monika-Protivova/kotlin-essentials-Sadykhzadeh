package com.motycka.edu.lesson02

val coffeeOrders = mutableMapOf<Int, List<String>>()

fun main() {
    // You can write code here to try the functions
    processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)
    processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)
//    processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0)
}

/* Implement the functions below */

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placerOrder(items)
    val totalToPay = payOrder(orderId)

    if (payment - totalToPay < 0) {
        error("Insufficient payment. Total to pay is $totalToPay, but received $payment.")
    }
    completeOrder(orderId)
    println("Payment successful. Total paid: $payment, Total to pay: $totalToPay, change: ${payment - totalToPay}")

    return payment - totalToPay
}

fun placerOrder(items: List<String>): Int {
    val orderId = coffeeOrders.size
    coffeeOrders[orderId] = items
    return orderId
}

fun completeOrder(orderId: Int) {
    coffeeOrders[orderId] ?: error("Order ID $orderId not found.")
    coffeeOrders.remove(orderId)

}

fun getPrice(item: String): Double {
    return when (item) {
        ESPRESSO -> ESPRESSO_PRICE
        DOUBLE_ESPRESSO -> DOUBLE_ESPRESSO_PRICE
        CAPPUCCINO -> CAPPUCCINO_PRICE
        LATTE -> LATTE_PRICE
        AMERICANO -> AMERICANO_PRICE
        FLAT_WHITE -> FLAT_WHITE_PRICE
        else -> error("$item is not on the menu!")
    }
}

fun payOrder(orderId: Int): Double {
    val items = coffeeOrders[orderId] ?: error("Order ID $orderId not found.")

    val prices = items.map {
        getPrice(it)
    }

    return prices.sum() - if (items.size > 3)
        prices.minOrNull() ?: 0.0 else 0.0
}