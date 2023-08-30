// !LANGUAGE: -WarnAboutNonExhaustiveWhenOnAlgebraicTypes -ProhibitNonExhaustiveWhenOnAlgebraicTypes

enum class SomeEnum {
    A, B
}

sealed class Base {
    class A : Base()
    class B : Base()
}

fun test1(x: Boolean): String {
    return <!NO_ELSE_IN_WHEN!>when<!> (x) {
        true -> ""
    }
}

fun test2(x: Boolean?): String {
    return when (x) {
        true -> ""
        else -> ""
    }
}

fun test3(x: Boolean?): String {
    return <!NO_ELSE_IN_WHEN!>when<!> (x) {
        true -> ""
        null -> ""
    }
}

fun test4(x: SomeEnum?): String {
    return <!NO_ELSE_IN_WHEN!>when<!> (x) {
        SomeEnum.A -> ""
        SomeEnum.B -> ""
    }
}

fun test5(x: SomeEnum?): String {
    return when (x) {
        SomeEnum.A -> ""
        SomeEnum.B -> ""
        null -> ""
    }
}