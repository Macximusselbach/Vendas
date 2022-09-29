package br.com.dionataferraz.vendas.transactions.domain.usecase

import br.com.dionataferraz.vendas.transactions.data.repository.TransactionRepository

class TransactionsUseCase {

    private val repository by lazy {
        TransactionRepository()

    }


}