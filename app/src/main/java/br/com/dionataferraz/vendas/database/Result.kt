package br.com.dionataferraz.vendas.database

sealed class Result<out S, out E> {
    data class Sucesss<S>(val value: S) : Result<S, Nothing>()
    data class Error<E>(val value: E) : Result<Nothing, E>()

    fun get(): S? {
        return when (this) {
            is Sucesss -> value
            else -> null
        }
    }
}
