package presentation.home

import domain.entity.Cuisine
import domain.entity.Offer
import domain.entity.Order
import domain.entity.Restaurant
import domain.entity.Taxi

fun Offer.toUiState(): OfferUiState {
    return OfferUiState(
        id = id,
        image = image
    )
}

fun Cuisine.toCuisineUiState(): CuisineUiState {
    return CuisineUiState(
        cuisineId = cuisineId,
        cuisineName = cuisineName,
        cuisineImageUrl = cuisineImageUrl,
    )
}

fun List<Cuisine>.toCuisineUiState() = map { it.toCuisineUiState() }


fun Restaurant.toRestaurantUiState(): RestaurantUiState {
    return RestaurantUiState(
        name = name,
        rating = rate,
        priceLevel = priceLevel
    )
}

fun List<Restaurant>.toRestaurantUiState() = map { it.toRestaurantUiState() }


fun Taxi.toUiState(): TaxiUiState {
    return TaxiUiState(
        id = id,
        color = color,
        plate = plate,
        timeToArriveInMints = timeToArriveInMints,
    )
}

fun Taxi.toOrderUiState(): TripUiState {
    return TripUiState(
        id = id,
        timeToArriveInMints = timeToArriveInMints,
    )
}

fun Order.toUiState(): OrderUiState {
    return OrderUiState(
        id = id,
        restaurantName = restaurantName,
    )
}
