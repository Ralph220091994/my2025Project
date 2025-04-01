package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier

data class Team(
    val id: Identifier,
    var points: Int
) {
    var name: String = ""
}

