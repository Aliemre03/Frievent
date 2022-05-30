package com.frievent.bitirme.controller

import com.frievent.bitirme.domain.DetailedEvent
import com.frievent.bitirme.domain.Event
import com.frievent.bitirme.domain.Participation
import com.frievent.bitirme.domain.Person
import com.frievent.bitirme.service.ParticipationService
import com.frievent.bitirme.util.Util
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping()
class ParticipationController(private val participationService: ParticipationService, private val util: Util) {

    @GetMapping("/participation")
    fun getMyParticaption(@RequestHeader("userid") userId: Long): List<DetailedEvent> {
       // return participationService.getMyParticipation(userId)
        return util.participatedDetailEvent(userId)
    }

    @PostMapping("/participation")
    fun enRoll(@RequestBody participation: Participation) {
        return participationService.save(participation)
    }

    @GetMapping("/test")
    fun test(): List<Person> {
        return participationService.deneme(9)
    }
}