package fr.jetdev.jade.models.activityReport

import java.time.Instant
import java.util.*

data class ActivityReportDayWrapper(
        val date: Date = Date.from(Instant.EPOCH),
        val activities: List<ActivityWrapper> = emptyList()
)
