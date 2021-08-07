package com.example.lazyverticalgrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Destination(
    @StringRes val nameId: Int,
    @DrawableRes val photoId: Int,
    @StringRes val descriptionId: Int
)
