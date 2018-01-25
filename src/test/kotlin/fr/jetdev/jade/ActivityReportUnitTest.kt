import fr.jetdev.jade.JadeApplication
import fr.jetdev.jade.models.activityReport.ActivityReportDayWrapper
import fr.jetdev.jade.models.activityReport.ActivityWrapper
import fr.jetdev.jade.services.ActivityReportService
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [JadeApplication::class])
class ActivityReportUnitTest {

    @Autowired
    lateinit var service: ActivityReportService

    @Test
    fun fetchAllActivityTypes() {
        val allActivityTypes = service.fetchAllActivityTypes()
        assertThat(allActivityTypes).isNotNull.hasSize(3)
    }

    @Test
    fun shouldFetchAnActivityReportWrapper() {
        val reportOfCollaboratorByMonth = service.fetchWrappedActivityReportOfCollaboratorByMonth(1, 1, 2018)
        assertThat(reportOfCollaboratorByMonth).isNotNull
    }

    @Test
    fun shouldSaveAnActivityReportWrapper() {
        val activityWrapper = ActivityWrapper(1, "Prestation", 8)
        val activityReportDayWrapper = ActivityReportDayWrapper(Date(), listOf(activityWrapper))

        service.saveActivityReportOfCollaborator(1, 1, 2018, listOf(activityReportDayWrapper))

        val reportOfCollaboratorByMonth = service.fetchWrappedActivityReportOfCollaboratorByMonth(1, 1, 2018)
        assertThat(reportOfCollaboratorByMonth).isNotNull
    }
}