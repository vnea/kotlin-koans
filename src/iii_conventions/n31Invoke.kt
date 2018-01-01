package iii_conventions

import util.TODO

// Can be better with primary constructor + default value but it's ok !
class Invokable {
    private var _numberOfInvocations = 0

    fun getNumberOfInvocations() = _numberOfInvocations

    operator fun invoke(): Invokable {
        ++_numberOfInvocations
        return this
    }
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change the class 'Invokable' to count the number of invocations:
        for 'invokable()()()()' it should be 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
