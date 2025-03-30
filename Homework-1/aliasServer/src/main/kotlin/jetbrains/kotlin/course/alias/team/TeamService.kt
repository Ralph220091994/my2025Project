package jetbrains.kotlin.course.alias.team

import org.springframework.stereotype.Service

@Service
class TeamService {
    companion object {
        val teamsStorage = mutableMapOf<Int, Team>()
    }

    fun generateTeamsForOneRound(number: Int): List<Team> {
        val teams = (1..number).map { id ->
            Team(id, 0, "Team $id")  // Creates a new team with default points
        }
        teams.forEach { teamsStorage[it.id] = it } // Store teams in teamsStorage
        return teams
    }
}
