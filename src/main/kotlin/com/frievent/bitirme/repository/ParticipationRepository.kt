package com.frievent.bitirme.repository

import com.frievent.bitirme.domain.Participation
import com.frievent.bitirme.domain.Person
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ParticipationRepository : CrudRepository<Participation, Long> {

    fun findAllByEventId(eventId: Long) : List<Participation>


    @Query(value = """
        select  u.name, u.user_id from users u
        inner join participatiens p on u.user_id = p.user_id
        where p.event_id = :eventId
    """, nativeQuery = true)
    fun findDetailed(eventId: Long) : List<Any>
}