package com.frievent.bitirme.repository

import com.frievent.bitirme.domain.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : CrudRepository<Category, Long>{
}