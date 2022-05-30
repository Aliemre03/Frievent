package com.frievent.bitirme.domain

data class DetailedEvent(
    val event: Event?,
    val participationList: List<Person>?
)
