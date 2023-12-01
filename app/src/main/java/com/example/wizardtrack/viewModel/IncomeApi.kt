package com.example.wizardtrack.viewModel

import android.util.Log
import com.example.wizardtrack.model.data.Income
import com.example.wizardtrack.model.dto.UserDTO
import com.example.wizardtrack.model.repository.IIncomeRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IncomeApi {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("${ApiRest}/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val apiService: IIncomeRepository = retrofit.create(IIncomeRepository::class.java)
    suspend fun getIncomes(userDTO: UserDTO):List<Income>{
        return try {
            apiService.getAll(userDTO)
        }catch (e: Exception){
            Log.e("Error getAll Icomes:", "${e.message}")
            emptyList()
        }
    }
    suspend fun getIncome(id :Long,userId:Long):Income{
        return try {
            apiService.getIncome(id,userId)
        }catch (e: Exception){
            Log.e("Error getIncome:", "${e.message}")
            Income()
        }
    }
    suspend fun saveIncome(income: Income):Income{
        return try {
            apiService.saveIncome(income)
        }catch (e: Exception){
            Log.e("Error saveIncome:", "${e.message}")
            Income()
        }
    }
    suspend fun updateIncome(income: Income):Income{
        return try {
            apiService.updateIncome(income)
        }catch (e: Exception){
            Log.e("Error updateIncome:", "${e.message}")
            Income()
        }
    }
    suspend fun deleteIncome(id:Long,idUser : Long): Income {
        return try {
            apiService.deleteIncome(id,idUser)
        }catch (e: Exception){
            Log.e("Error deleteIncome:", "${e.message}")
            Income()
        }
    }
}