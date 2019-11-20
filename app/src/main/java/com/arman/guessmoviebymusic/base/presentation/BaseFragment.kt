package com.arman.guessmoviebymusic.base.presentation

import android.media.SoundPool
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arman.guessmoviebymusic.extension.play
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
            findNavController().popBackStack()
        }
    }

}