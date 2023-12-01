package com.example.wizardtrack.model.repository

import com.example.wizardtrack.model.data.Spent
import com.example.wizardtrack.model.dto.UserDTO
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ISpentRepository {
    @POST("SpentRestController/All")
    suspend fun getAll(@Body user: UserDTO): List<Spent>

    @POST("SpentRestController")
    suspend fun saveSpent(@Body spent: Spent): Spent

    @GET("SpentRestController/{id}/{idUser}")
    suspend fun getSpent(@Path("id") id: Long, @Path("idUser") idUser: Long): Spent

    @PUT("SpentRestController")
    suspend fun updateSpent(@Body spent: Spent): Spent

    @DELETE("SpentRestController/{id}/{idUser}")
    suspend fun deleteSpent(@Path("id") id: Long, @Path("idUser") idUser: Long): Spent
}
