package com.example.android.ui_components

import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject


abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    private val soundPool: SoundPool by inject()

    abstract fun soundOnBackPressed(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            soundPool.play(soundOnBackPressed())
//            findNavController().popBackStack()
        }
    }

    @Suppress("UNUSED_PARAMETER")
    protected fun popBackStack(view: View) {
//        Timber.d("popBackStack")
        soundPool.play(soundOnBackPressed())
//        findNavController().popBackStack()
    }

}