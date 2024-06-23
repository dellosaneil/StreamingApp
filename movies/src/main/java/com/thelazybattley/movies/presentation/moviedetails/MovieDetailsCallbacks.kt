package com.thelazybattley.movies.presentation.moviedetails

interface MovieDetailsCallbacks {

    fun hasTextOverflow(hasTextOverflow: Boolean)

    fun showMoreTextClicked()

    companion object {
        fun default() = object : MovieDetailsCallbacks {
            override fun hasTextOverflow(hasTextOverflow: Boolean) {
                TODO("Not yet implemented")
            }

            override fun showMoreTextClicked() {
                TODO("Not yet implemented")
            }

        }
    }

}
