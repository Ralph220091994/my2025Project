import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import jetbrains.kotlin.course.alias.card.CardService
import jetbrains.kotlin.course.alias.team.TeamService

@Component
class StartupShutdownListener(val cardService: CardService, val teamService: TeamService) : ApplicationListener<ApplicationReadyEvent> {

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        // Load game state when the server starts
        // No need to load, as the services handle it in their constructors

        // Call saveGameState to persist game data when server shuts down
        Runtime.getRuntime().addShutdownHook(Thread {
            cardService.saveGameState()
            teamService.saveGameState()
        })
    }
}
