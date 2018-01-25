package fr.jetdev.jade.models

data class Address(

        val id: Int = 0,
        val line1: String = "",
        val line2: String? = "",
        val line3: String? = "",
        val line4: String? = "",
        val city: String = "",
        val postalCode: String = "",
        val country: String = "",
        val countryProvince: String? = "",
        val otherDetails: String? = ""
)