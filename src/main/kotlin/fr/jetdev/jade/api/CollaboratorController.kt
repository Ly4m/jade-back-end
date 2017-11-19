package fr.jetdev.jade.api

import fr.jetdev.jade.models.Collaborator
import fr.jetdev.jade.services.CollaboratorService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
internal class CollaboratorController(val service : CollaboratorService) {

    @RequestMapping("/collaborator/{id}")
    fun getCollaborator(@PathVariable id:Long) : Collaborator? {
        return service.fetchCity(id)
    }

}