package jetbrains.kotlin.course.alias.util

import jetbrains.kotlin.course.alias.Identifier

class IdentifierFactory {
    private var counter: Identifier = 0

    fun uniqueIdentifier(): Identifier {
        return counter++
    }
}