package fr.jetdev.jade.models

import java.util.Date
import java.time.Instant

data class MissionOrder(
        val id: Int = 0,
        val collaboratorId: Int = 0,
        val clientId: Int = 0,
        val startDate: Date = Date.from(Instant.EPOCH),
        val endDate: Date = Date.from(Instant.EPOCH),
        val addressId: Int = 0
)