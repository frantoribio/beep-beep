package org.thechance.common.domain.usecase

import org.thechance.common.domain.entity.DataWrapper
import org.thechance.common.domain.entity.RestaurantInformation
import org.thechance.common.domain.entity.Restaurant
import org.thechance.common.domain.getway.IRestaurantGateway


interface IManageRestaurantUseCase {

    suspend fun createRestaurant(restaurant: RestaurantInformation): Restaurant

    suspend fun getRestaurant(
        pageNumber: Int,
        numberOfRestaurantsInPage: Int,
        restaurantName: String,
        rating: Double,
        priceLevel: Int
    ): DataWrapper<Restaurant>

    suspend fun deleteRestaurant(id: String): Boolean

    suspend fun getRestaurantById(id: String): Restaurant

    suspend fun updateRestaurant(
        restaurantId: String,
        ownerId: String,
        restaurant: RestaurantInformation
    ): Restaurant

}


class ManageRestaurantUseCase(private val restaurantGateway: IRestaurantGateway) :
    IManageRestaurantUseCase {

    override suspend fun createRestaurant(restaurant: RestaurantInformation): Restaurant {
        return restaurantGateway.createRestaurant(restaurant)
    }

    override suspend fun getRestaurant(
        pageNumber: Int,
        numberOfRestaurantsInPage: Int,
        restaurantName: String,
        rating: Double,
        priceLevel: Int
    ): DataWrapper<Restaurant> {
        return restaurantGateway.getRestaurants(
            pageNumber,
            numberOfRestaurantsInPage,
            restaurantName,
            rating,
            priceLevel
        )
    }

    override suspend fun deleteRestaurant(id: String): Boolean {
        return restaurantGateway.deleteRestaurant(id)
    }

    override suspend fun getRestaurantById(id: String): Restaurant {
        return restaurantGateway.getRestaurantById(id)
    }

    override suspend fun updateRestaurant(
        restaurantId: String,
        ownerId: String,
        restaurant: RestaurantInformation
    ): Restaurant {
        return restaurantGateway.updateRestaurant(restaurantId, ownerId, restaurant)
    }

}