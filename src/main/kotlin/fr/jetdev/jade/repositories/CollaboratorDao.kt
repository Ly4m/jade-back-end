package fr.jetdev.jade.repositories

import fr.jetdev.jade.models.Collaborator
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface CollaboratorDao {

    fun fetchById(id: Long): Collaborator

    fun fetchAllCollaborators(): List<Collaborator>

}