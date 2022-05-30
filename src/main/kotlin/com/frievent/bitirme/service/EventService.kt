package com.frievent.bitirme.service

import com.frievent.bitirme.domain.DetailedEvent
import com.frievent.bitirme.domain.Event
import com.frievent.bitirme.repository.EventRepository

import org.springframework.stereotype.Service

@Service
class EventService(private val eventRepository: EventRepository) {

    fun getMyEvents(eventOwnerId: Long): List<Event> {
        return eventRepository.findByEventOwnerId(eventOwnerId) as List<Event>
    }

    fun findAll(): List<Event> {
        return eventRepository.findAll() as List<Event>
    }

    fun saveEvent(event: Event) {
        eventRepository.save(event)
    }

    fun deleteEvent(event: Event) {
        val deletedEvent = eventRepository.findByEventId(event.eventId!!)

        if (deletedEvent != null && deletedEvent.eventOwnerId == event.eventOwnerId)
            eventRepository.delete(deletedEvent)
    }

}
