package com.frievent.bitirme.service

import com.frievent.bitirme.domain.Login
import com.frievent.bitirme.domain.User
import com.frievent.bitirme.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll() as List<User>
    }

    fun saveUser(user: User) {
        userRepository.save(user)
    }

    fun findUser(login: Login): User? {
        return userRepository.findByEmailAndPassword(login.email, login.password)
    }

    fun findParticatedUser(userId: Long): Optional<User> {
        return userRepository.findById(userId)
    }


}