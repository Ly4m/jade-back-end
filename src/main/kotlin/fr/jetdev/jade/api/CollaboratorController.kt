package fr.jetdev.jade.api

import fr.jetdev.jade.models.Collaborator
import fr.jetdev.jade.services.CollaboratorService
import org.springframework.web.bind.annotation.*

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

    @PutMapping("/collaborator/{id}")
    fun updateCollaborator(@PathVariable id: Long, @RequestBody collaborator: Collaborator) {
        service.updateCollaborator(collaborator)
    }
}