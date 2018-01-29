package fr.jetdev.jade.repositories

import fr.jetdev.jade.models.MissionOrder
import org.apache.ibatis.annotations.Mapper

@Mapper
internal interface MissionOrderDao {

    fun fetchMissionOrderById(id: Long): MissionOrder

    fun fetchAllMissionOrders(): List<MissionOrder>

}