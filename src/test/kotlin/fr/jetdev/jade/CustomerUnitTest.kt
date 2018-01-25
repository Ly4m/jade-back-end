package fr.jetdev.jade

import fr.jetdev.jade.models.Address
import fr.jetdev.jade.repositories.AddressDao
import fr.jetdev.jade.services.CustomerService
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [JadeApplication::class])
class CustomerUnitTest {

    @Autowired
    lateinit var addressDao: AddressDao

    @Autowired
    lateinit var customerService: CustomerService

    @Test
    fun shouldInsertAnAddress() {
        val address = Address(line1 = "12b route de Lens",
                city = "Izel-les-équerchins",
                country = "FRANCE",
                postalCode = "62490")
        addressDao.createAddress(address)
        Assertions.assertThat(address.id).isNotNull().isNotEqualTo(0)
    }

    @Test
    fun shouldDeleteAnAddress() {
        val address = Address(line1 = "12b route de Lens",
                city = "Izel-les-équerchins",
                country = "FRANCE",
                postalCode = "62490")
        addressDao.createAddress(address)
        addressDao.clearAddressById(address.id)
        val list = addressDao.fetchAll()
        Assertions.assertThat(list).isEmpty()
    }
}