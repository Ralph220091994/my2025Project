package jetbrains.kotlin.course.alias.card

import alias.JsCard
import jetbrains.kotlin.course.alias.util.toJsCard
import org.springframework.web.bind.annotation.*
import java.lang.reflect.InvocationTargetException

@RestController
@RequestMapping("/api/cards/")
class CardResource(private val service: CardService) {

    @CrossOrigin
    @GetMapping("/card")
    fun getCardByIndex(@RequestParam index: Int): JsCard =
        service.getCardByIndex(index)?.toJsCard()
            ?: throw InvocationTargetException(IllegalArgumentException("Invalid index: $index"))

    @CrossOrigin
    @GetMapping("/amount")
    fun getCardsAmount(): Int = service.getCardsAmount()
}

