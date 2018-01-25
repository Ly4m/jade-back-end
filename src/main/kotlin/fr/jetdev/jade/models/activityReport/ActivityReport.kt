package fr.jetdev.jade.models.activityReport

data class ActivityReport(
        val id: Long = 0,
        val month: Int = 0,
        val year: Int = 0,
        val activities: MutableList<Activity> = mutableListOf()
)
