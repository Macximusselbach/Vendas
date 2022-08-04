package br.com.dionataferraz.vendas.presentation.presenter

interface LoginContract {
    interface View {
        fun displayErrorMessage()
        fun displaySucessToast()
        fun startHomeActivity()
    }

    interface Presenter {
        fun isLoginValid(userName: String, password: String)
    }
}
