package com.example.android.ui_components

import android.content.DialogInterface
import android.media.SoundPool
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

abstract class BaseFullDialogFragment : DialogFragment() {

//    private val soundPool: SoundPool by inject()
//    private val soundCancel: Int by inject(named(SOUND_CANCEL))
//    protected val soundUiTap: Int by inject(named(SOUND_UI_TAP_NAME))

    protected abstract fun getLayout(): Int

    override fun onStart() {
//        Timber.d("onStart")
        super.onStart()
        dialog?.window?.apply {
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            setWindowAnimations(R.style.AppTheme_Slide)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Timber.d("onActivityCreated")
        return inflater.inflate(getLayout(), container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        Timber.d("onCreate")
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
    }

    private fun playSoundCancel() {
//        soundPool.play(soundCancel)
    }

    @Suppress("UNUSED_PARAMETER")
    protected fun closeDialog(view: View) {
//        Timber.d("onClickClose $view")
        playSoundCancel()
        dismiss()
    }

    override fun onCancel(dialog: DialogInterface) {
//        Timber.d("onCancel")
        super.onCancel(dialog)
        playSoundCancel()
    }

}