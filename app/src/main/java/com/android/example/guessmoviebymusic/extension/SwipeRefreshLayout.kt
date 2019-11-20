package com.android.example.guessmoviebymusic.extension

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


@SuppressWarnings("Not used")
fun SwipeRefreshLayout.startRefreshing() {
    isRefreshing = true
}

@SuppressWarnings("Not used")
fun SwipeRefreshLayout.stopRefreshing() {
    isRefreshing = false
}


