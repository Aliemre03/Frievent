package com.frievent.bitirme.util

import com.frievent.bitirme.domain.DetailedEvent
import com.frievent.bitirme.domain.Event
import com.frievent.bitirme.domain.Person
import com.frievent.bitirme.repository.EventRepository
import com.frievent.bitirme.service.EventService
import com.frievent.bitirme.service.ParticipationService
import com.frievent.bitirme.service.UserService
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.Date

@Component
class Util(
    private val eventService: EventService,
    private val participationService: ParticipationService,
    private val userService: UserService,
    private val eventRepository: EventRepository
) {
    fun getDetailedEvent(customQuery: Map<String, String>): List<DetailedEvent> {
        val events: List<Event>
        val date = LocalDateTime.now()

        events = if (customQuery.keys.contains("categoryId")) {
            if (customQuery["sort"] == "desc")
                eventRepository.findAllByDateAfterAndCategoryIdOrderByDateDesc(date,customQuery["categoryId"]!!.toLong())
            else
                eventRepository.findAllByDateAfterAndCategoryIdOrderByDateAsc(date,customQuery["categoryId"]!!.toLong())
        } else {
            if (customQuery["sort"] == "desc")
                eventRepository.findAllByDateAfterOrderByDateDesc(date)
            else
                eventRepository.findAllByDateAfterOrderByDateAsc(date)
        }

        return mapEventAndUser(events)

    }

    fun getMyDetailedEvent(eventOwnerId: Long): List<DetailedEvent> {
        val myEvents = eventService.getMyEvents(eventOwnerId)
        return mapEventAndUser(myEvents)
    }

    fun participatedDetailEvent(id: Long): List<DetailedEvent> {
        val events = eventRepository.findAllByUserId(id)
        return mapEventAndUser(events)
    }

    fun mapEventAndUser(events: List<Event>): List<DetailedEvent> {
        val detailedEventList = mutableListOf<DetailedEvent>()

        events.forEach {
            val participatorList = participationService.findParaticipators(it.eventId!!)
            val personList = mutableListOf<Person>()
            participatorList.forEach {
                val user = userService.findParticatedUser(it.userId!!)
                user.ifPresent {
                    personList.add(Person(it.name, it.userId))
                }
            }
            detailedEventList.add(DetailedEvent(it, personList))
        }
        return detailedEventList
    }
}