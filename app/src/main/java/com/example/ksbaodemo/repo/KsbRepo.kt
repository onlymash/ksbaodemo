package com.example.ksbaodemo.repo

import com.example.ksbaodemo.data.KsbClass
import com.example.ksbaodemo.extensions.NetResult

interface KsbRepo {
    suspend fun fetchKsbClass(isHot: Boolean): NetResult<KsbClass>
}