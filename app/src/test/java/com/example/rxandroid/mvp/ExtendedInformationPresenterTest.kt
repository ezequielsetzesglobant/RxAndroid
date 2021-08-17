package com.example.rxandroid.mvp

import com.example.rxandroid.mvp.contract.ExtendedInformationContract
import com.example.rxandroid.mvp.presenter.ExtendedInformationPresenter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class ExtendedInformationPresenterTest {

    private val view: ExtendedInformationContract.ExtendedInformationViewContract = mock()
    private val presenter: ExtendedInformationContract.ExtendedInformationPresenterContract = ExtendedInformationPresenter(view)

    @Test
    fun `on close clicked test`() {
        presenter.onCloseClicked()

        verify(view).closeFragment()
    }
}
