package jetbrains.kotlin.course.alias.results

import alias.JsTeam
import jetbrains.kotlin.course.alias.util.toGameResult
import org.springframework.web.bind.annotation.*
import jetbrains.kotlin.course.alias.team.TeamService

class GameJsResult : ArrayList<JsTeam>()

@RestController
@RequestMapping("/api/results/")
class GameResultsResource(
    val service: GameResultsService,
    val teamService: TeamService // Inject TeamService
) {
    @CrossOrigin
    @PostMapping("/save")
    fun saveGameResults(@RequestBody result: GameJsResult) =
        service.saveGameResults(result.toGameResult(teamService)) // Pass teamService

    @CrossOrigin
    @GetMapping("/all")
    fun getAllGameResults() = service.getAllGameResults()
}

