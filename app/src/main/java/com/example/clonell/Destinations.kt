package com.example.clonell

interface Destinations {
    val route: String
}

object Screen1 : Destinations {
    override val route: String
        get() = "Setting"
}

object Screen2 : Destinations {
    override val route: String
        get() = "Home"
}

object Screen3 : Destinations {
    override val route: String
        get() = "Email"
}

object Detail : Destinations {
    override val route: String
        get() = "Detail"
    const val argDishId = "dishID"
}