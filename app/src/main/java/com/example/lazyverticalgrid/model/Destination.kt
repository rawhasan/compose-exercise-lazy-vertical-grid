package com.example.lazyverticalgrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.util.*

data class Destination(
    @StringRes val nameId: Int,
    @DrawableRes val photoId: Int,
    @StringRes val descriptionId: Int,
    val destinationId: UUID = UUID.randomUUID()
)
