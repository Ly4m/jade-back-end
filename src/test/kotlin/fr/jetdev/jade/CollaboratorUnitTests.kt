import fr.jetdev.jade.JadeApplication
import fr.jetdev.jade.services.CollaboratorService
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [JadeApplication::class])
class CollaboratorUnitTests {

    @Autowired
    lateinit var service: CollaboratorService

    @Test
    fun shouldFetchCollaboratorWithIDOne() {
        val william = service.fetchCollaboratorById(1)
        assertThat(william).isNotNull().hasFieldOrPropertyWithValue("firstName", "William").hasFieldOrPropertyWithValue("lastName","Leemans")
    }

    @Test
    fun shouldFetchAllCollaborators() {
        val allCollaborators = service.fetchAllCollaborators()
        assertThat(allCollaborators).isNotNull.hasSize(5)
    }

}