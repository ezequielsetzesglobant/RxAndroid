package com.example.rxandroid.mvp.contract

interface ExtendedInformationContract {

    interface ExtendedInformationPresenterContract {
        fun onCloseClicked()
    }

    interface ExtendedInformationViewContract {
        fun closeFragment()
    }
}
