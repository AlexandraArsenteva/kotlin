sealed class A {
    class A1 : A()
    class A2 : A()
}

fun foo(arg: A): String {
    return when(arg) {
        is A.A1 -> "a"
        else -> "b"
    }
}

fun bar(arg: A): String {
    when(arg) {
        is A.A1 -> "a"
        else -> "b"
    }
    return "a"
}