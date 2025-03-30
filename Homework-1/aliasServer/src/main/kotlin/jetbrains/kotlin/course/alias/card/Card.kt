package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.Identifier

data class Card(
    val id: Identifier,
    val words: List<Word>
)
