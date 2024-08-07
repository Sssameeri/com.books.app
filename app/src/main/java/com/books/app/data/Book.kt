package com.books.app.data

data class Book(
    val id: Int,
    val coverTitle: String,
    val coverImage: String,
    val author: String,
    val summary: String =
        """
            According to researchers at Duke University, habits 
            account for about 40 percent of our behaviors on
            any given day. Your life today is essentially the sum 
            of your habits. How in shape or out of shape 
            you are? A result of your habits. How happy or unhappy 
            you are? A result of your habits. How successful 
            or unsuccessful you are? A result of your habits.
            or unsuccessful you are? A result of your habits.
            or unsuccessful you are? A result of your habits.
            or unsuccessful you are? A result of your habits.
        """.trimIndent()
)