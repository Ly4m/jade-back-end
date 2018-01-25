package fr.jetdev.jade.repositories

import fr.jetdev.jade.models.activityReport.Activity
import fr.jetdev.jade.models.activityReport.ActivityReport
import fr.jetdev.jade.models.activityReport.ActivityType
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface ActivityReportDao {

    fun fetchActivityReportOfCollaboratorByMonth(
            @Param("collaboratorId") collaboratorId: Int,
            @Param("month") month: Int,
            @Param("year") year: Int
    ): ActivityReport

    fun fetchAllActivityTypes(): List<ActivityType>

    fun clearActivityReportById(@Param("reportId") reportId: Long)

    fun createActivityList(@Param("activities") activities: List<Activity>, @Param("reportId") reportId: Long)
}