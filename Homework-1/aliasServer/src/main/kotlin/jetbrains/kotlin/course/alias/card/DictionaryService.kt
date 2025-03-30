package jetbrains.kotlin.course.alias.util

import org.springframework.stereotype.Service
import java.util.*

@Service
class DictionaryService {
    // Define categories with words
    private val categorizedWords = mapOf(
        "fruits" to listOf("apple", "banana", "orange", "grape", "pear", "melon", "kiwi", "mango", "peach", "plum"),
        "animals" to listOf("dog", "cat", "elephant", "tiger", "lion", "giraffe", "zebra", "kangaroo", "panda", "rabbit"),
        "countries" to listOf("USA", "Canada", "Mexico", "Brazil", "India", "China", "Russia", "Japan", "Germany", "Australia"),
        "colors" to listOf("red", "blue", "green", "yellow", "purple", "orange", "pink", "brown", "black", "white")
    )

    // Get a random word from the specified category
    fun getRandomWord(category: String): String {
        val words = categorizedWords[category]
        if (words != null && words.isNotEmpty()) {
            return words.random()
        }
        return "Unknown category" // Return a default if category doesn't exist or is empty
    }
}
