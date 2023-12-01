package com.example.wizardtrack.model.repository
import com.example.wizardtrack.model.dto.LoginServiceDTO
import com.example.wizardtrack.model.dto.SignUpServiceDTO
import com.example.wizardtrack.model.dto.UserDTO
import retrofit2.http.Body
import retrofit2.http.POST
interface ILoginRepository {
    @POST("login")
    suspend fun login(@Body user: LoginServiceDTO): UserDTO

    @POST("signup")
    suspend fun signup(@Body user: SignUpServiceDTO): UserDTO
}