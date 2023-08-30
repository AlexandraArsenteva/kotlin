// FIR_IDENTICAL

sealed class A {
    class B() : A()
    class C() : A()
}

fun test1(arg: A?): Int {
    if (arg == null) {
        return 0
    }
    when (<!DEBUG_INFO_SMARTCAST!>arg<!>) {
        is A.B -> 1
        is A.C -> 3
        // else or null branch should not be required here!
    }
    return 1
}

fun test2(arg: A?): Int {
    if (arg == null) {
        return 0
    }
    return when (<!DEBUG_INFO_SMARTCAST!>arg<!>) {
        is A.B -> 1
        is A.C -> 3
        // else or null branch should not be required here!
    }
}

fun test3(arg: A?): Int {
    return when (arg) {
        is A.B -> 1
        is A.C -> 2
        null -> 3
    }
}