package fr.jetdev.jade.api

import fr.jetdev.jade.models.MissionOrder
import fr.jetdev.jade.services.MissionOrderService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:9000"])
@RestController
internal class MissionOrderController(val service: MissionOrderService) {

    @RequestMapping("/mission-order/{id}")
    fun getCollaborator(@PathVariable id: Long): MissionOrder? {
        return service.fetchMissionOrderById(id)
    }

    @RequestMapping("/mission-order")
    fun getAllCollaborators(): List<MissionOrder>? {
        return service.fetchAllMissionOrders()
    }

}