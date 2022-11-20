package lotto.domain

data class LottoNumber(val value: Int) {

    init {
        validateNumberRange(this.value)
    }

    private fun validateNumberRange(number: Int) {
        require(number in MINIMUM_VALUE..MAXIMUM_VALUE) {
            "로또 번호는 $MINIMUM_VALUE ~ $MAXIMUM_VALUE 범위 내에서 입력 가능합니다."
        }
    }

    companion object {
        private const val MINIMUM_VALUE = 1
        private const val MAXIMUM_VALUE = 45
    }
}
