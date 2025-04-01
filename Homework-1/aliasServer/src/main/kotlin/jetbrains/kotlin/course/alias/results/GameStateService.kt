package jetbrains.kotlin.course.alias.util

import com.google.gson.Gson
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import jetbrains.kotlin.course.alias.results.GameResult
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.card.Card
import org.springframework.stereotype.Service

@Service
class GameStateService {

    private val gson = Gson()

    // File where the game state will be saved
    private val gameStateFile = File("gameState.json")

    // Save the current game state to a file
    fun saveGameState(
        gameHistory: List<GameResult>,
        teamsStorage: Map<Int, Team>,
        lastAssignedCardId: Int,
        lastAssignedTeamId: Int,
        usedWords: List<String>,
        usedCards: List<Card>
    ) {
        val gameState = GameState(
            gameHistory,
            teamsStorage,
            lastAssignedCardId,
            lastAssignedTeamId,
            usedWords,
            usedCards
        )

        val writer = FileWriter(gameStateFile)
        gson.toJson(gameState, writer)
        writer.close()
    }

    // Load the saved game state from a file
    fun loadGameState(): GameState? {
        if (!gameStateFile.exists()) {
            return null
        }

        val reader = FileReader(gameStateFile)
        val gameState = gson.fromJson(reader, GameState::class.java)
        reader.close()

        return gameState
    }
}
