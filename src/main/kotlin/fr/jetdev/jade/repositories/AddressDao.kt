package fr.jetdev.jade.repositories

import fr.jetdev.jade.models.Address
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface AddressDao {

    fun createAddress(address: Address)

    fun clearAddressById(@Param("id") addressId: Int)

    fun fetchAll(): List<Address>
}