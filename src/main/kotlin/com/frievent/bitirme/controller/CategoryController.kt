package com.frievent.bitirme.controller

import com.frievent.bitirme.domain.Category
import com.frievent.bitirme.service.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping()
class CategoryController(private val categoryService: CategoryService) {

    @GetMapping("/category")
    fun findAllCategory() :List<Category>{
        return categoryService.findAll()
    }
}