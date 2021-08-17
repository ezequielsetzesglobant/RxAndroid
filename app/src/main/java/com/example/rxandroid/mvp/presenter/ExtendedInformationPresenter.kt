package com.example.rxandroid.mvp.presenter

import com.example.rxandroid.mvp.contract.ExtendedInformationContract

class ExtendedInformationPresenter(private val view: ExtendedInformationContract.ExtendedInformationViewContract) :
    ExtendedInformationContract.ExtendedInformationPresenterContract {

    override fun onCloseClicked() {
        view.closeFragment()
    }
}
