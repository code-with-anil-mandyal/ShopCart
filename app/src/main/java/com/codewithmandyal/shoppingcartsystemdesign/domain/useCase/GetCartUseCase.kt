package com.codewithmandyal.shoppingcartsystemdesign.domain.useCase

import com.codewithmandyal.shoppingcartsystemdesign.domain.repository.CartRepository
import javax.inject.Inject

class GetCartUseCase @Inject constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke(id: Int) = repository.getCart(id)
}