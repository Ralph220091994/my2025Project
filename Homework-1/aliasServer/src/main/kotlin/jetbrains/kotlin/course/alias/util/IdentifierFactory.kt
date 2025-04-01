package jetbrains.kotlin.course.alias.util

// Using the value class or type alias
typealias Identifier = Int

class IdentifierFactory {
    private var counter: Identifier = 0

    fun uniqueIdentifier(): Identifier {
        return counter++
    }

    fun getLastAssignedId(): Identifier {
        return counter
    }

    fun setLastAssignedId(id: Identifier) {
        counter = id
    }
}
