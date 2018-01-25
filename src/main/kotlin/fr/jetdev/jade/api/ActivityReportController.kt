package fr.jetdev.jade.api

import fr.jetdev.jade.models.activityReport.ActivityReportDayWrapper
import fr.jetdev.jade.models.activityReport.ActivityType
import fr.jetdev.jade.services.ActivityReportService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:9000"])
@RestController()
@RequestMapping("/activity-report")
internal class ActivityReportController(val activityReportService: ActivityReportService) {

    @RequestMapping("/wrapper/{idCollaborator}/{month}/{year}")
    fun getWrappedCollaboratorsActivityReportForAMonth(@PathVariable idCollaborator: Int,
                                                       @PathVariable month: Int,
                                                       @PathVariable year: Int): List<ActivityReportDayWrapper>? {
        return activityReportService.fetchWrappedActivityReportOfCollaboratorByMonth(idCollaborator, month, year)
    }

    @RequestMapping("/activity-types")
    fun fetchAllActivityTypes(): List<ActivityType> {
        return activityReportService.fetchAllActivityTypes()
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/{idCollaborator}/{month}/{year}"])
    fun saveActivityReport(@PathVariable idCollaborator: Int, @PathVariable month: Int, @PathVariable year: Int, @RequestBody report: List<ActivityReportDayWrapper>) {
        activityReportService.saveActivityReportOfCollaborator(idCollaborator, month, year, report)
    }
}