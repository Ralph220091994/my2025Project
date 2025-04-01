package jetbrains.kotlin.course.alias.results

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

@Service
class GameResultsService(private val teamService: TeamService = TeamService()) {
    companion object {
        private val gameHistory: MutableList<GameResult> = mutableListOf()
    }

    fun saveGameResults(result: GameResult) {
        if (result.isEmpty()) {
            throw IllegalArgumentException("Game result cannot be empty.")
        }

        // Access teamsStorage from the companion object
        val validTeamIds = TeamService.teamsStorage.keys
        if (!result.all { it.id in validTeamIds }) {
            throw IllegalArgumentException("Some team IDs in the result do not exist in TeamService.")
        }

        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> = gameHistory.reversed()
}
