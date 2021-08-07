package com.example.lazyverticalgrid.data

import com.example.lazyverticalgrid.R
import com.example.lazyverticalgrid.model.Destination

class DestinationDataSource {
    fun loadData(): List<Destination> {
        return listOf(
            Destination(R.string.destination1, R.drawable.image1, R.string.description1),
            Destination(R.string.destination2, R.drawable.image2, R.string.description2),
            Destination(R.string.destination3, R.drawable.image3, R.string.description3),
            Destination(R.string.destination4, R.drawable.image4, R.string.description4),
            Destination(R.string.destination5, R.drawable.image5, R.string.description5),
            Destination(R.string.destination6, R.drawable.image6, R.string.description6)
        )
    }
}