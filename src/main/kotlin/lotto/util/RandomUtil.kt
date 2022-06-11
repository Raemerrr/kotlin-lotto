package lotto.util

object RandomUtil {
    fun getShuffledNumbers(intRange: IntRange, size: Int): List<Int> {
        return intRange.shuffled().take(size)
    }
}