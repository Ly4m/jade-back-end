package fr.jetdev.jade.services

import fr.jetdev.jade.models.Collaborator
import fr.jetdev.jade.models.MissionOrder
import fr.jetdev.jade.repositories.CollaboratorDao
import fr.jetdev.jade.repositories.MissionOrderDao
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
internal class MissionOrderService(val missionOrderDao: MissionOrderDao) {

    fun fetchMissionOrderById(missionOrderId: Long): MissionOrder? {
        return missionOrderDao.fetchMissionOrderById(missionOrderId)
    }

    fun fetchAllMissionOrders(): List<MissionOrder> {
        return missionOrderDao.fetchAllMissionOrders();
    }

}