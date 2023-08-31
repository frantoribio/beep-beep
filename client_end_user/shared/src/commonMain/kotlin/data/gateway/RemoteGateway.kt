package data.gateway

import data.remote.mapper.toEntity
import data.remote.model.BaseResponse
import data.remote.model.SessionDto
import domain.entity.Session
import domain.gateway.IRemoteGateway
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.http.isSuccess
import io.ktor.http.parameters

class RemoteGateway(private val client: HttpClient) : IRemoteGateway {

    override suspend fun createUser(
        fullName: String,
        username: String,
        password: String,
        email: String
    ): Boolean {
        try {
            val response = client.submitForm(
                formParameters = parameters {
                    append("fullName", fullName)
                    append("username", username)
                    append("password", password)
                    append("email", email)
                }
            ) {
                url("/signup")
                header("Accept-Language", "en")
            }
            val responseBody = response.body<BaseResponse<Boolean>>()
            if (response.status.isSuccess()) {
                return responseBody.value ?: false
            } else {
                throw Exception(responseBody.status.errorMessages.toString())
            }
        } catch (exception: Exception) {
            throw Exception(exception.message)
        }
    }

    override suspend fun loginUser(username: String, password: String): Session {
        try {
            val response = client.submitForm(
                formParameters = parameters {
                    append("username", username)
                    append("password", password)
                }
            ) {
                url("/login")
                header("Accept-Language", "en")
            }
            val responseBody = response.body<BaseResponse<SessionDto>>()
            if (response.status.isSuccess()) {
                return responseBody.value?.toEntity() ?: throw Exception()
            } else {
                throw Exception(responseBody.status.errorMessages.toString())
            }

        } catch (exception: Exception) {
            throw Exception(exception.message)
        }
    }

}