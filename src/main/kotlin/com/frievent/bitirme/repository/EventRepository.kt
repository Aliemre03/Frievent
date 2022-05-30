package com.frievent.bitirme.repository

import com.frievent.bitirme.domain.Event
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : PagingAndSortingRepository<Event, Long> {

    fun findByEventOwnerId(eventOwnerId: Long): List<Event?>
    fun findByEventId(eventId: Long): Event?

    @Query(
        value = """ select e.* from participatiens p
    inner join events e on p.event_id = e.event_id 
     where p.user_id = :userId
    """, nativeQuery = true
    )
    fun findAllByUserId(userId: Long): List<Event>

}