package com.example.wizardtrack.viewModel


import android.util.Log
import com.example.wizardtrack.model.data.SaveCount
import com.example.wizardtrack.model.dto.UserDTO
import com.example.wizardtrack.model.repository.ISaveCountRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SaveCountApi {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("${ApiRest}/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val apiService: ISaveCountRepository = retrofit.create(ISaveCountRepository::class.java)
    suspend fun getSaveCount(id:Long,userId:Long): SaveCount {
        return try {
            apiService.getSaveCount(id,userId)
        }catch (e: Exception){
            Log.e("Error getSaveCount:", "${e.message}")
            SaveCount()
        }
    }
    suspend fun getSaveCounts(userDTO: UserDTO):List<SaveCount>{
        return try {
            apiService.getAll(userDTO)
        }catch (e: Exception){
            Log.e("Error getAll SaveCount:", "${e.message}")
            emptyList()
        }
    }
    suspend fun saveSaveCount(saveCount: SaveCount): SaveCount {
        return try {
            apiService.saveSaveCount(saveCount)
        }catch (e: Exception){
            Log.e("Error saveSaveCount:", "${e.message}")
            SaveCount()
        }
    }
    suspend fun updateSaveCount(saveCount: SaveCount): SaveCount {
        return try {
            apiService.updateSaveCount(saveCount)
        }catch (e: Exception){
            Log.e("Error updateSaveCount:", "${e.message}")
            SaveCount()
        }
    }
    suspend fun deleteSaveCount(id:Long,idUser : Long): SaveCount {
        return try {
            apiService.deleteSaveCount(id,idUser)
        }catch (e: Exception){
            Log.e("Error deleteSaveCount:", "${e.message}")
            SaveCount()
        }
    }

}