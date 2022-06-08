package blackjack.view.output.converter

import blackjack.domain.CardNumber
import blackjack.domain.Player
import blackjack.domain.PlayingCard
import blackjack.domain.PlayingCards
import blackjack.domain.Suit
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class StartOfGameConverterTest {
    @Test
    fun `StartOfGameConverter는 게임이 시작될 때의 플레이어 정보들을 출력을 위한 문자열로 변환해 반환한다`() {
        val player1 = Player.from("mona").apply {
            receive(
                PlayingCards.from(
                    listOf(
                        PlayingCard.of(Suit.SPADES, CardNumber.TWO),
                        PlayingCard.of(Suit.HEARTS, CardNumber.ACE)
                    )
                )
            )
        }
        val player2 = Player.from("skull").apply {
            receive(
                PlayingCards.from(
                    listOf(
                        PlayingCard.of(Suit.DIAMONDS, CardNumber.JACK),
                        PlayingCard.of(Suit.CLUBS, CardNumber.SEVEN)
                    )
                )
            )
        }

        val expected = "mona, skull에게 2장을 나누었습니다.\nmona카드: 2스페이드, A하트\nskull카드: J다이아몬드, 7클로버"
        Assertions.assertThat(StartOfGameConverter.convert(listOf(player1, player2))).isEqualTo(expected)
    }
}
