package com.frievent.bitirme.domain

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "events")
data class Event(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    val eventId: Long?,
    @Column(name = "event_owner_id")
    val eventOwnerId: Long?,
    @Column(name = "category_id")
    val categoryId: Long?,
    @Column(name = "title")
    val title: String,
    @Column(name = "description")
    val description: String,
    @Column(name = "date")
    val date: LocalDateTime,
    @Column(name = "location")
    val location: String,
    @Column(name = "participation")
    val limit: Int,
    @Column(name = "color")
    val color: String?
)
