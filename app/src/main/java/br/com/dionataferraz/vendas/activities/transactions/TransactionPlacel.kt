package br.com.dionataferraz.vendas.activities.transactions

class TransactionPlace() {

    fun checkPlace(place: String): String {

        return check(place)
    }

    fun check(place: String): String {
        if (place == Place.MARKET.name) {
            return Place.MARKET.name

        } else if (place == Place.GASOLINE.name) {
            return Place.GASOLINE.name

        } else if (place == Place.SOCIAL.name) {
            return Place.SOCIAL.name

        } else {
            return Place.SOCIAL.name

        }

    }

}

enum class Place(local: String) {
    MARKET("Market"),
    GASOLINE("Gasoline"),
    SOCIAL("Social")
}
