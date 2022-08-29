package de.imedia24.shop.db.entity

import de.imedia24.shop.domain.product.ProductResponse
import io.swagger.v3.oas.annotations.media.Schema
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
data class ProductEntity(
        @Id
        @Column(name = "sku", nullable = false)
        val sku: String = "",

        @Column(name = "name", nullable = false)
        val name: String = "",

        @Column(name = "description")
        val description: String? = null,

        @Column(name = "price", nullable = false)
        val price: BigDecimal = BigDecimal.ZERO,

        @CreationTimestamp
        @Column(name = "created_at", nullable = false)
        val createdAt: ZonedDateTime = ZonedDateTime.now(),

        @UpdateTimestamp
        @Column(name = "updated_at", nullable = false)
        val updatedAt: ZonedDateTime = ZonedDateTime.now()


) {


    companion object {
        fun ProductResponse.toProductEntity() = ProductEntity(
                sku = sku,
                name = name,
                description = description,
                price = price
        )
    }
}
