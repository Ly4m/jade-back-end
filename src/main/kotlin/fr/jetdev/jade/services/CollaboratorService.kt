package fr.jetdev.jade.services

import fr.jetdev.jade.models.Collaborator
import fr.jetdev.jade.repositories.CollaboratorDao
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
internal class CollaboratorService(val collaboratorDao: CollaboratorDao) {

    fun fetchCollaboratorById(collaboratorId: Long): Collaborator? {
        return collaboratorDao.fetchById(collaboratorId)
    }

    fun fetchAllCollaborators(): List<Collaborator> {
        return collaboratorDao.fetchAllCollaborators();
    }

}