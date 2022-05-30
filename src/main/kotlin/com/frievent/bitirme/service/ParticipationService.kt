package com.frievent.bitirme.service

import com.frievent.bitirme.domain.DetailedEvent
import com.frievent.bitirme.domain.Event
import com.frievent.bitirme.domain.Participation
import com.frievent.bitirme.domain.Person
import com.frievent.bitirme.repository.EventRepository
import com.frievent.bitirme.repository.ParticipationRepository
import com.frievent.bitirme.util.Util
import org.springframework.stereotype.Service

@Service
class ParticipationService(
    private val participationRepository: ParticipationRepository,
) {

    fun save(participation: Participation) {
        participationRepository.save(participation)
    }

    fun findParaticipators(eventId: Long): List<Participation>{
       return participationRepository.findAllByEventId(eventId)
    }

    fun deneme(eventId: Long): List<Person> {
       val list =  participationRepository.findDetailed(eventId)
        return list as List<Person>
    }
}