package fr.jetdev.jade.api

import fr.jetdev.jade.models.Collaborator
import fr.jetdev.jade.services.CollaboratorService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:9000"])
@RestController
internal class CollaboratorController(val service : CollaboratorService) {

    @RequestMapping("/collaborator/{id}")
    fun getCollaborator(@PathVariable id:Long) : Collaborator? {
        return service.fetchCollaboratorById(id)
    }

    @RequestMapping("/collaborator")
    fun getAllCollaborators() : List<Collaborator>? {
        return service.fetchAllCollaborators()
    }

}