package com.frievent.bitirme.repository

import com.frievent.bitirme.domain.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User,Long> {

    fun findByEmailAndPassword(email: String, password: String):User?



}