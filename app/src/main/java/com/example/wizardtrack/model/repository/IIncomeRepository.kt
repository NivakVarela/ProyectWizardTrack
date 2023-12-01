package com.example.wizardtrack.model.repository

import com.example.wizardtrack.model.data.Income
import com.example.wizardtrack.model.dto.UserDTO
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IIncomeRepository {
    @POST("IncomeRest")
    suspend fun saveIncome(@Body income: Income): Income

    @POST("IncomeRest/All")
    suspend fun getAll(@Body user: UserDTO): List<Income>

    @GET("IncomeRest/{id}/{idUser}")
    suspend fun getIncome(@Path("id") id: Long, @Path("idUser") idUser: Long): Income

    @PUT("IncomeRest")
    suspend fun updateIncome(@Body income: Income): Income

    @DELETE("IncomeRest/{id}/{idUser}")
    suspend fun deleteIncome(@Path("id") id: Long, @Path("idUser") idUser: Long): Income
}
