package vi_generics

import util.TODO
import java.util.*

fun task41(): Nothing = TODO(
    """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    return partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    return partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
}

// BAD VERSION
fun List<String>.partitionTo(words: ArrayList<String>, lines: ArrayList<String>, predicate: (String) -> Boolean): Pair<List<String>, List<String>> {
    for (element in this) {
        if (predicate(element)) {
            words.add(element)
        }
        else {
            lines.add(element)
        }
    }

    return Pair(words, lines)
}

// BAD VERSION
fun Set<Char>.partitionTo(letters: HashSet<Char>, otherSymbols: HashSet<Char>, predicate: (Char) -> Boolean): Pair<Set<Char>, Set<Char>>  {
    for (element in this) {
        if (predicate(element)) {
            letters.add(element)
        }
        else {
            otherSymbols.add(element)
        }
    }

    return Pair(letters, otherSymbols)
}

// BEST VERSION
//fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(first: C, second: C, predicate: (T) -> Boolean): Pair<C, C> {
//    for (element in this) {
//        if (predicate(element)) {
//            first.add(element)
//        } else {
//            second.add(element)
//        }
//    }
//    return Pair(first, second)
//}