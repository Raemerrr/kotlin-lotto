package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoShopTest {

    private lateinit var shop: LottoShop

    @BeforeEach
    fun setup() {
        shop = LottoShop()
    }

    @ParameterizedTest(name = "구입 금액이 0원보다 작으면 RuntimeException 예외가 발생해야 한다.")
    @ValueSource(
        ints = [-10000, -50000]
    )
    fun lottoShopNegative(amount: Int) {
        assertThrows<RuntimeException> { shop.buy(amount) }
    }

    @ParameterizedTest(name = "구매한 금액 만큼의 로또가 발급되어야 한다.")
    @CsvSource(
        value = [
            "14000|14",
            "0|0",
            "37500|37"
        ],
        delimiter = '|'
    )
    fun lottoShopCount(amount: Int, count: Int) {
        val actual = shop.buy(amount).size
        assertThat(actual).isEqualTo(count)
    }
}