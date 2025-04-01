package jetbrains.kotlin.course.alias.util

import jetbrains.kotlin.course.alias.card.Card
import jetbrains.kotlin.course.alias.results.GameResult
import jetbrains.kotlin.course.alias.team.Team

data class GameState(
    val gameHistory: List<GameResult>,
    val teamsStorage: Map<Int, Team>,
    val lastAssignedCardId: Int,
    val lastAssignedTeamId: Int,
    val usedWords: List<String>,
    val usedCards: List<Card>
)
