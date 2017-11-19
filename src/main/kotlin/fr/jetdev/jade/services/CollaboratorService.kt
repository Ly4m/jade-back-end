package fr.jetdev.jade.services

import fr.jetdev.jade.models.Collaborator
import fr.jetdev.jade.repositories.CollaboratorDao
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
internal class CollaboratorService(val collaboratorDao: CollaboratorDao) {

    fun fetchCity(collaboratorId: Long): Collaborator? {
        return collaboratorDao.findById(collaboratorId)
    }

}