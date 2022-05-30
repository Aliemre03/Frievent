package com.frievent.bitirme.service

import com.frievent.bitirme.domain.Category
import com.frievent.bitirme.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {

    fun findAll() : List<Category>{
        return categoryRepository.findAll() as List<Category>
    }
}