package com.example.rxandroid.mvp.view

import com.example.rxandroid.databinding.FragmentExtendedInformationBinding
import com.example.rxandroid.fragment.ExtendedInformationFragment
import com.example.rxandroid.mvp.contract.ExtendedInformationContract
import com.example.rxandroid.mvp.view.base.FragmentView

class ExtendedInformationView(fragment: ExtendedInformationFragment, private val binding: FragmentExtendedInformationBinding) :
    FragmentView(fragment), ExtendedInformationContract.ExtendedInformationViewContract {

    override fun closeFragment() {
        (fragment as? ExtendedInformationFragment)?.dismiss()
    }
}
