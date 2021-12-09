package lotto.generator

import lotto.domain.entity.common.LottoNumber
import lotto.domain.generator.LottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(strings = ["1, 3, 10, 11, 43, 32", "2, 3, 4, 10, 15, 41"])
    fun `지난 주 로또 번호 입력시 입력한 번호가 생성되는지 확인한다`(lottoNumber: String) {
        val creatLottoNumber = LottoGenerator.generatorLotto(lottoNumber)
        val inputLottoNumber = lottoNumber.split(",").map { LottoNumber(it.trim().toInt()) }.sortedBy { it.number }.toList()
        checkSameWinningLottoNumber(creatLottoNumber, inputLottoNumber)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1, 3, 10, 20 , 43, 45", "1, 32, 38, 41, 44, 50"])
    fun `지난 주 로또 번호 입력시 (1~45) 에 포함 되어 있지 않을 경우 IllegalArgumentException 예외가 발생한다`(lottoNumber: String) {
        assertThrows<IllegalArgumentException> { LottoGenerator.generatorLotto(lottoNumber) }
    }

    private fun checkSameWinningLottoNumber(createLottoNumber: List<LottoNumber>, inputLottoNumber: List<LottoNumber>) {
        for (index in 0 until LOTTO_SIZE) {
            assertThat(createLottoNumber[index].number).isEqualTo(inputLottoNumber[index].number)
        }
    }

    companion object {
        private const val LOTTO_SIZE = 6
    }
}