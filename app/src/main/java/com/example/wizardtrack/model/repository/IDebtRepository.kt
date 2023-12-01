package com.example.wizardtrack.model.repository

import com.example.wizardtrack.model.data.Debt
import com.example.wizardtrack.model.dto.UserDTO
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IDebtRepository {
    @POST("DebtRest/All")
    suspend fun getAll(@Body user: UserDTO): List<Debt>

    @POST("DebtRest")
    suspend fun saveDebt(@Body debt: Debt): Debt

    @GET("DebtRest/{id}/{idUser}")
    suspend fun getDebt(@Path("id") id: Long, @Path("idUser") idUser: Long): Debt

    @PUT("DebtRest")
    suspend fun updateDebt(@Body debt: Debt): Debt

    @DELETE("DebtRest/{id}/{idUser}")
    suspend fun deleteDebt(@Path("id") id: Long, @Path("idUser") idUser: Long): Debt
}