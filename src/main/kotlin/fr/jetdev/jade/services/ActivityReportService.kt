package fr.jetdev.jade.services

import fr.jetdev.jade.models.activityReport.*
import fr.jetdev.jade.repositories.ActivityReportDao
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ActivityReportService(private val activityReportDao: ActivityReportDao) {


    private fun fetchActivityReportOfCollaboratorByMonth(collaboratorId: Int, month: Int, year: Int): ActivityReport {
        return activityReportDao.fetchActivityReportOfCollaboratorByMonth(collaboratorId, month, year)
    }

    fun fetchAllActivityTypes(): List<ActivityType> {
        return activityReportDao.fetchAllActivityTypes()
    }

    fun saveActivityReportOfCollaborator(collaboratorId: Int, month: Int, year: Int, report: List<ActivityReportDayWrapper>) {
        val activityReport = fetchActivityReportOfCollaboratorByMonth(collaboratorId, month, year)

        val listOfActivity = convertWrapperToListOfActivity(report)

        clearActivityReport(activityReport.id)
        if (listOfActivity.isNotEmpty()) {
            activityReportDao.createActivityList(listOfActivity, activityReport.id)
        }
    }

    fun fetchWrappedActivityReportOfCollaboratorByMonth(collaboratorId: Int, month: Int, year: Int): List<ActivityReportDayWrapper> {
        val activityReport = fetchActivityReportOfCollaboratorByMonth(collaboratorId, month, year)
        return convertListOfActivityToWrapper(activityReport.activities)
    }

    private fun clearActivityReport(reportId: Long) = activityReportDao.clearActivityReportById(reportId)

    private fun convertWrapperToListOfActivity(report: List<ActivityReportDayWrapper>) =
            report.flatMap { fullDayOfActivities ->
                fullDayOfActivities.activities
                        .map { Activity(null, fullDayOfActivities.date, it.duration, ActivityType(it.id, it.label)) }
            }

    private fun convertListOfActivityToWrapper(activities: List<Activity>): List<ActivityReportDayWrapper> =
            activities.groupBy { it.date }
                    .map { (date, activities) ->
                        ActivityReportDayWrapper(date,
                                activities
                                        .map { ActivityWrapper(it.activityType?.id ?: 0, it.activityType?.label ?: "", it.durationInHour) })
                    }


}