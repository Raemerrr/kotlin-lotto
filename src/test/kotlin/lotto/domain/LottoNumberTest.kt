package lotto.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ValueSource(ints = [1, 30, 45])
    @ParameterizedTest
    fun `로또 객체 생성 - 성공`(input: Int) {
        assertDoesNotThrow {
            LottoNumber(input)
        }
    }

    @ValueSource(ints = [-1, 0, 46])
    @ParameterizedTest
    fun `로또 객체 생성 - 실패`(input: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(input)
        }
    }
}
