package fr.jetdev.jade.services

import fr.jetdev.jade.models.Address
import fr.jetdev.jade.repositories.AddressDao
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CustomerService(private val addressDao: AddressDao) {

    fun createAddress(address: Address) {
        addressDao.createAddress(address)
    }
}