package com.example.wizardtrack.viewModel

import android.util.Log
import com.example.wizardtrack.model.data.Debt
import com.example.wizardtrack.model.dto.UserDTO
import com.example.wizardtrack.model.repository.IDebtRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger

class DebtApi {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("${ApiRest}/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val apiDebtService: IDebtRepository = retrofit.create(IDebtRepository::class.java)
    suspend fun getDebts(user: UserDTO):List<Debt>{
        return try {
            apiDebtService.getAll(user)
        }catch (e: Exception){
            Log.e("Error getAll Debt:", "${e.message}")
            emptyList()
        }
    }
    suspend fun getDebt(id :Long,userId:Long):Debt{
        return try {
            apiDebtService.getDebt(id,userId)
        }catch (e: Exception){
            Log.e("Error getDebt:", "${e.message}")
            Debt()
        }
    }
    suspend fun saveDebt(debt: Debt):Debt{
        return try {
            apiDebtService.saveDebt(debt)
        }catch (e: Exception){
            Log.e("Error saveDebt:", "${e.message}")
            Debt()
        }
    }
    suspend fun updateDebt(debt: Debt):Debt{
        return try {
            apiDebtService.updateDebt(debt)
        }catch (e: Exception){
            Log.e("Error updateDebt:", "${e.message}")
            Debt()
        }
    }
    suspend fun deleteDebt(id:Long,idUser : Long):Debt{
        return try {
            apiDebtService.deleteDebt(id,idUser)
        }catch (e: Exception){
            Log.e("Error deleteDebt:", "${e.message}")
            Debt()
        }
    }

}