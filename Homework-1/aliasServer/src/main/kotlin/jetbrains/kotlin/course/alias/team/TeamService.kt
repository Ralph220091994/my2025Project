package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.GameStateService
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService(
    private val gameStateService: GameStateService = GameStateService(),
    private val identifierFactory: IdentifierFactory = IdentifierFactory()
) {
    companion object {
        // This is the shared teamsStorage
        val teamsStorage = mutableMapOf<Int, Team>()
    }

    init {
        val savedState = gameStateService.loadGameState()
        if (savedState != null) {
            teamsStorage.putAll(savedState.teamsStorage)
            identifierFactory.setLastAssignedId(savedState.lastAssignedTeamId)
        }
    }

    // Public method to get the teamsStorage
    fun getTeamsStorage(): Map<Int, Team> = teamsStorage

    fun generateTeam(): Team {
        val teamId: Int = identifierFactory.uniqueIdentifier()
        val team = Team(teamId, 0)
        teamsStorage[team.id] = team
        saveGameState()
        return team
    }

    fun getTeamById(id: Int): Team? = teamsStorage[id]

    fun generateTeamsForOneRound(number: Int): List<Team> = List(number) { generateTeam() }

    fun saveGameState() {
        gameStateService.saveGameState(
            gameHistory = listOf(),
            teamsStorage = teamsStorage,
            lastAssignedCardId = 0,
            lastAssignedTeamId = identifierFactory.getLastAssignedId(),
            usedWords = listOf(),
            usedCards = listOf()
        )
    }
}
