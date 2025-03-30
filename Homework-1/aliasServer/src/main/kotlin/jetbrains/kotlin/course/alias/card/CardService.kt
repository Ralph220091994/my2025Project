package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.DictionaryService
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class CardService(val dictionaryService: DictionaryService) {
    private val identifierFactory = IdentifierFactory()
    private val cards: List<Card> = generateCards()

    companion object {
        const val WORDS_IN_CARD = 4
        private const val TOTAL_CARDS = 20

        val cardsAmount: Int
            get() = TOTAL_CARDS
    }

    // Randomly select a category from the available categories
    private fun getRandomCategory(): String {
        val categories = listOf("fruits", "animals", "countries", "colors")
        return categories.random()  // Randomly pick a category
    }

    // Generate cards by picking words from a random category
    private fun generateCards(): List<Card> {
        return (1..cardsAmount).map {
            val category = getRandomCategory() // Get a random category for each card
            Card(identifierFactory.uniqueIdentifier(), List(WORDS_IN_CARD) { Word(dictionaryService.getRandomWord(category)) })
        }
    }

    fun getCardByIndex(index: Int): Card {
        if (index !in cards.indices) throw IndexOutOfBoundsException("Invalid card index: $index")
        return cards[index]
    }
}
