package com.example.wizardtrack.viewModel

import android.util.Log
import com.example.wizardtrack.model.dto.LoginServiceDTO
import com.example.wizardtrack.model.dto.SignUpServiceDTO
import com.example.wizardtrack.model.dto.UserDTO
import com.example.wizardtrack.model.repository.ILoginRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SessionService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("${ApiRest}/Account/SesionRest/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val apiService: ILoginRepository = retrofit.create(ILoginRepository::class.java)

    suspend fun login(user: LoginServiceDTO):UserDTO{
        return try {
            apiService.login(user)
        }catch (e: Exception){
            Log.e("Error login:", "${e.message}")
            UserDTO(0,"Error API","")
        }
    }
    suspend fun signup(user: SignUpServiceDTO):UserDTO{
        return try {
            apiService.signup(user)
        }catch (e: Exception){
            Log.e("Error login:", "${e.message}")
            UserDTO(0,"Error API","")
        }
    }
}