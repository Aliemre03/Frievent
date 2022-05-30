package com.frievent.bitirme.controller

import com.frievent.bitirme.domain.DetailedEvent
import com.frievent.bitirme.domain.Event
import com.frievent.bitirme.service.EventService
import com.frievent.bitirme.util.Util
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping()
class EventController(private val eventService: EventService, private val util: Util ) {
   @GetMapping("/events")
    fun getAllEvents(): List<DetailedEvent> {
        return util.getDetailedEvent()
    }

    @GetMapping("/my-events")
    fun getEvents(@RequestHeader("userid") eventOwnerId: Long): List<DetailedEvent> {
       // return eventService.getMyEvents(eventOwnerId)
        return util.getMyDetailedEvent(eventOwnerId)
    }

    @PostMapping("/my-events")
    fun saveEvent(@RequestHeader("userid") userId: Long,@RequestBody event: Event) {
        val myEvent = event.copy(eventOwnerId = userId)
        return eventService.saveEvent(myEvent)
    }

    @DeleteMapping("/my-events")
    fun deleteEvent(@RequestBody event: Event) {
        return eventService.deleteEvent(event)
    }
}