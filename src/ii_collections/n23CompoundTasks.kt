package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    return customers
            .filter { it.orderedProducts.contains(product) }
            .toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders
            .filter { it.isDelivered }
            .flatMap { it.products }
            .maxBy { it.price }
}

// BAD VERSION ? (USING fold)
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return customers.fold(
            0,
            {
                nbTimesProductWasOrdered,
                customer ->
                    nbTimesProductWasOrdered +
                    customer
                        .orders
                        .flatMap { it.products }
                        .count { it == product }
            }
    )
}

// BEST VERSION
//fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
//    // Return the number of times the given product was ordered.
//    // Note: a customer may order the same product for several times.
//    return customers.flatMap { it.orders }.flatMap { it.products }.count { it == product }
//}