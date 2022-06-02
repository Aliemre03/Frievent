package com.frievent.bitirme.repository

import com.frievent.bitirme.domain.Event
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.Date

@Repository
interface EventRepository : PagingAndSortingRepository<Event, Long> {

    fun findByEventOwnerId(eventOwnerId: Long): List<Event?>
    fun findByEventId(eventId: Long): Event?

    fun findAllByDateAfterAndCategoryIdOrderByDateDesc(date: LocalDateTime,categoryId: Long): List<Event>

    fun findAllByDateAfterAndCategoryIdOrderByDateAsc(date: LocalDateTime,categoryId: Long): List<Event>



    fun findAllByDateAfterOrderByDateDesc(date: LocalDateTime): List<Event>
    fun findAllByDateAfterOrderByDateAsc(date: LocalDateTime): List<Event>

    @Query(
        value = """ select e.* from participatiens p
    inner join events e on p.event_id = e.event_id 
     where p.user_id = :userId
    """, nativeQuery = true
    )
    fun findAllByUserId(userId: Long): List<Event>

}