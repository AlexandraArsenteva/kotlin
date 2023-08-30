fun test1(x: Int): Int =
    when (x) {
        1, 10 -> 1
        2, 30, 45 -> 2
        else -> 0
    }

fun test2(x: Int): Int =
    when (x) {
        1, 10 -> 1
        2, <!DUPLICATE_LABEL_IN_WHEN!>1<!> -> 2
        else -> 0
    }

fun test3(x: Int): Int =
<!NO_ELSE_IN_WHEN!>when<!> (x)
{
    1, 10 -> 1
    2, 30 -> 2
}

fun test4(x: Int): Int {
    when (x) {
        1, 10 -> 1
        2, 30 -> 2
    }
    return 1
}

fun test5(x: Boolean): Int =
    when (x) {
        true, false, <!SENSELESS_NULL_IN_WHEN!>null<!> -> 1
    }

enum class E { A, B }

fun test6(x: E): Int =
    when (x) {
        E.A, E.B -> 1
    }

sealed class A {
    class A1 : A()
    class A2 : A()
}

fun test7(x: A?): Int =
    when (x) {
        is A.A1, is A.A2, null -> 1
    }

fun test8(x:Any) =
    when (x) {
        1, "a" -> 1
        2, "b" -> 2
        else -> 3
    }
