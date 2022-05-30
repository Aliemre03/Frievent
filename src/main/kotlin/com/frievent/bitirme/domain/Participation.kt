package com.frievent.bitirme.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "participatiens")
data class Participation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participation_id")
    var participationId: Long?,

    @Column(name = "event_id")
    var eventId: Long?,

    @Column(name = "user_id")
    var userId: Long?,

    @Column(name = "status")
    var status: String?

)
