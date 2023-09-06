package org.thechance.service_location.api.models

import io.ktor.server.websocket.*
import kotlinx.coroutines.flow.MutableStateFlow
import org.thechance.service_identity.endpoints.model.LocationDto

data class WebSocketTrip(val ownerSession: DefaultWebSocketServerSession){
    val location = MutableStateFlow(LocationDto())
}