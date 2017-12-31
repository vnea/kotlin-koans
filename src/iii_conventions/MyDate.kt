package iii_conventions

// MyDate
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval) = addTimeIntervals(
    repeatedTimeInterval.timeInterval,
    repeatedTimeInterval.nbTimes
)

operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)


// TimeInterval
enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(nbTimes: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, nbTimes)

// RepeatedTimeInterval
class RepeatedTimeInterval(val timeInterval: TimeInterval, val nbTimes: Int)

// DateRange
class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current = start

            override fun hasNext(): Boolean {
                return current <= endInclusive
            }

            override fun next(): MyDate {
                val nextDay = current
                current = current.nextDay()

                return nextDay
            }
        }
    }

    operator fun contains(date: MyDate): Boolean {
        return date in start..endInclusive
    }
}
