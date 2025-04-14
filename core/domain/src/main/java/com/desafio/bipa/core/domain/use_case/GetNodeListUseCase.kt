package com.desafio.bipa.core.domain.use_case

import com.desafio.bipa.core.data.model.Node
import com.desafio.bipa.core.data.repository.LightningRepository

class GetNodeListUseCase(
    private val lightningRepository: LightningRepository
) {

    suspend operator fun invoke(): List<Node> = lightningRepository.getNodes()
}