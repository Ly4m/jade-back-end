package fr.jetdev.jade.models.activityReport

import java.time.Instant
import java.util.*

data class Activity (
        val id: Int? = null,
        val date: Date = Date.from(Instant.EPOCH),
        val durationInHour: Int = 0,
        val activityType: ActivityType? = null
)
