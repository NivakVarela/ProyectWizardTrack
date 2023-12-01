package com.example.wizardtrack.viewModel

import android.util.Log
import com.example.wizardtrack.model.data.Spent
import com.example.wizardtrack.model.dto.UserDTO
import com.example.wizardtrack.model.repository.ISpentRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpentApi {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("${ApiRest}/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val apiService: ISpentRepository = retrofit.create(ISpentRepository::class.java)

    suspend fun getSpents(userDTO: UserDTO):List<Spent>{
        return try {
            apiService.getAll(userDTO)
        }catch (e: Exception){
            Log.e("Error getAll Spents:", "${e.message}")
            emptyList()
        }
    }
    suspend fun getSpent(id :Long,userId:Long):Spent{
        return try {
            apiService.getSpent(id,userId)
        }catch (e: Exception){
            Log.e("Error getSpent:", "${e.message}")
            Spent()
        }
    }
    suspend fun saveSpent(spent: Spent):Spent{
        return try {
            apiService.saveSpent(spent)
        }catch (e: Exception){
            Log.e("Error saveSpent:", "${e.message}")
            Spent()
        }
    }
    suspend fun updateSpent(spent: Spent):Spent{
        return try {
            apiService.updateSpent(spent)
        }catch (e: Exception){
            Log.e("Error updateSpent:", "${e.message}")
            Spent()
        }
    }
    suspend fun deleteSpent(id:Long,idUser : Long):Spent{
        return try {
            apiService.deleteSpent(id,idUser)
        }catch (e: Exception){
            Log.e("Error deleteSpent:", "${e.message}")
            Spent()
        }
    }
}