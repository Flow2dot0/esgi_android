package com.florian.gustin.domain

interface ProductContract {
    val name: String
    val brand: String
    val barcode: Long
    val nutriscore: String
    val imageUrl: String
    val quantity: String
    val countries: List<String>
    val ingredients: List<String>
    val allergenes: List<String>
    val additives: List<String>
}

class Product private constructor(
    override val name: String,
    override val brand: String,
    override val barcode: Long,
    override val nutriscore: String,
    override val imageUrl: String,
    override val quantity: String,
    override val countries: List<String>,
    override val ingredients: List<String>,
    override val allergenes: List<String>,
    override val additives: List<String>
) : ProductContract {
    companion object {
        fun of(
            name: String,
            brand: String,
            barcode: Long,
            nutriscore: String,
            imageUrl: String,
            quantity: String,
            countries: List<String>,
            ingredients: List<String>,
            allergenes: List<String>,
            additives: List<String>
        ): Product {
            return Product(
                name,
                brand,
                barcode,
                nutriscore,
                imageUrl,
                quantity,
                countries,
                ingredients,
                allergenes,
                additives
            );
        }

        fun petitPoisEtCarottes(): Product {
            return Product(
                "Petits pois et carottes",
                "Cassegrain",
                3083680085304,
                "nutriscore_e",
                "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
                "400 g (280 g net égoutté)",
                listOf("France", "Japon", "Suisse"),
                listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
                listOf("Aucune"),
                listOf("Aucun")
            )
        }
    }

}

