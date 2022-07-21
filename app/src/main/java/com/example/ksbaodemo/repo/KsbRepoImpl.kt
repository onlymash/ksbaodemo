package com.example.ksbaodemo.repo

import com.example.ksbaodemo.api.KsbaoApi
import com.example.ksbaodemo.data.KsbClass
import com.example.ksbaodemo.extensions.NetResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KsbRepoImpl(val api: KsbaoApi) : KsbRepo {

    override suspend fun fetchKsbClass(isHot: Boolean): NetResult<KsbClass> {
        return withContext(Dispatchers.IO) {
            try {
                val ksbClass = api.getKsbClass(if (isHot) 1 else 0)
                NetResult.Success(ksbClass)
            } catch (e: Exception) {
                NetResult.Error(e)
            }
        }
    }
}