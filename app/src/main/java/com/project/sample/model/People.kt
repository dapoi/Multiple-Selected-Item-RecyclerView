package com.project.sample.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class People(
    var name: String,
    var age: Int
): Parcelable
