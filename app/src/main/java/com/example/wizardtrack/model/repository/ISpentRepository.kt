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
    @POST("SpentRest/All")
    suspend fun getAll(@Body user: UserDTO): List<Spent>

    @POST("SpentRest")
    suspend fun saveSpent(@Body spent: Spent): Spent

    @GET("SpentRest/{id}/{idUser}")
    suspend fun getSpent(@Path("id") id: Long, @Path("idUser") idUser: Long): Spent

    @PUT("SpentRest")
    suspend fun updateSpent(@Body spent: Spent): Spent

    @DELETE("SpentRest/{id}/{idUser}")
    suspend fun deleteSpent(@Path("id") id: Long, @Path("idUser") idUser: Long): Spent
}
