package fr.jetdev.jade.models

data class Customer(
        val id: Int = 0,
        val name: String = "",
        val address: Address? = null,
        val phone: Long = 0
)