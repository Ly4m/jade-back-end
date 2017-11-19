package fr.jetdev.jade.repositories

import fr.jetdev.jade.models.Collaborator
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
internal interface CollaboratorDao {

    @Select("""
        SELECT * FROM jade."Collaborator" WHERE id=#{id}
    """)
    fun findById(@Param("id") id: Long): Collaborator
}