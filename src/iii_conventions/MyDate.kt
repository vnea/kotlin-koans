package iii_conventions

// BAD AND VERY UGLY VERSION (and maybe it doesn't work in every cases)
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year < other.year) {
            return -1
        }

        if (year == other.year && month < other.month) {
            return -1
        }

        if (year == other.year && month == other.month && dayOfMonth < other.dayOfMonth) {
            return -1
        }

        if (dayOfMonth == other.dayOfMonth) {
            return 0
        }

        return 1
    }
}

// BEST VERSION
//data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
//    override fun compareTo(other: MyDate) = when {
//        year != other.year -> year - other.year
//        month != other.month -> month - other.month
//        else -> dayOfMonth - other.dayOfMonth
//    }
//}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)
