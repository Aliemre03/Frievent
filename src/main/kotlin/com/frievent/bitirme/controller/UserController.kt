package com.frievent.bitirme.controller

import com.frievent.bitirme.domain.Error
import com.frievent.bitirme.domain.Login
import com.frievent.bitirme.domain.User
import com.frievent.bitirme.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class UserController(private val userService: UserService) {
    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable("id") id: Long): User? {
        return userService.findUserById(id)
    }

    @PostMapping("/register")
    fun saveUser(@RequestBody user: User): ResponseEntity<*> {
        val checkUser = Login(user.email, user.password)
        val isExist = userService.findUser(checkUser)

        return if (isExist != null)
            ResponseEntity(Error("User already exist"), HttpStatus.BAD_REQUEST)
        else {
            userService.saveUser(user)
            ResponseEntity(user, HttpStatus.OK)
        }
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody login: Login): ResponseEntity<*> {
        val user = userService.findUser(login)
        if (user != null)
            return ResponseEntity(user, HttpStatus.OK)

        return ResponseEntity(Error("User is not valid"), HttpStatus.BAD_REQUEST)
    }
}