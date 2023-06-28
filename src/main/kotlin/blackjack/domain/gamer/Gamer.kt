package blackjack.domain.gamer

import blackjack.domain.card.Card
import blackjack.domain.card.Cards
import blackjack.domain.state.GamerState

abstract class Gamer {

    var state = GamerState.wait()
        private set

    fun init(initCards: Cards) {
        state = state.init(initCards)
    }

    fun hit(card: Card) {
        state = state.hit(card)
    }

    fun hasCard(): Boolean {
        return state.cards.value.isNotEmpty()
    }

    fun notHasCards(): Boolean {
        return state.cards.value.isEmpty()
    }

    fun stay() {
        state = state.stay()
    }

    abstract fun canHit(): Boolean
}
