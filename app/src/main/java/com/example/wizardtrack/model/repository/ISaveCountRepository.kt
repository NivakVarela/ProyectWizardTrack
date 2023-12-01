package com.example.wizardtrack.model.repository

import com.example.wizardtrack.model.data.SaveCount
import com.example.wizardtrack.model.dto.UserDTO
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ISaveCountRepository {
    @POST("SaveCountRestController/All")
    suspend fun getAll(@Body user: UserDTO): List<SaveCount>

    @POST("SaveCountRestController")
    suspend fun saveSaveCount(@Body saveCount: SaveCount): SaveCount

    @GET("SaveCountRestController/{id}/{idUser}")
    suspend fun getSaveCount(@Path("id") id: Long, @Path("idUser") idUser: Long): SaveCount

    @PUT("SaveCountRestController")
    suspend fun updateSaveCount(@Body saveCount: SaveCount): SaveCount

    @DELETE("SaveCountRestController/{id}/{idUser}")
    suspend fun deleteSaveCount(@Path("id") id: Long, @Path("idUser") idUser: Long): SaveCount
}
