// !LANGUAGE: -WarnAboutNonExhaustiveWhenOnAlgebraicTypes -ProhibitNonExhaustiveWhenOnAlgebraicTypes

enum class SomeEnum {
    A, B
}

sealed class Base {
    class A : Base()
    class B : Base()
}

sealed interface IBase {
    interface A : IBase
    interface B : IBase
}

// ------------------ not null ------------------

fun test_1(x: SomeEnum) {
    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        SomeEnum.A -> ""
    }
}

fun test_2(x: Base) {
    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        is Base.A -> ""
    }
}

fun test_3(x: IBase) {
    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        is IBase.A -> ""
    }
}

fun test_4(x: Boolean) {
    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        true -> ""
    }
}

fun test_4_1(x: Boolean): String {
    return <!NO_ELSE_IN_WHEN!>when<!> (x) {
        true -> ""
    }
}


// ------------------ nullable ------------------

fun test_5(x: SomeEnum?) {
    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        SomeEnum.A -> ""
        SomeEnum.B -> ""
    }

    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        SomeEnum.A -> ""
        null -> ""
    }
}

fun test_5_1(x: SomeEnum?): String {
    return <!NO_ELSE_IN_WHEN!>when<!> (x) {
        SomeEnum.A -> ""
        SomeEnum.B -> ""
    }
}

fun test_5_2(x: SomeEnum?): String {
    return when (x) {
        SomeEnum.A -> ""
        SomeEnum.B -> ""
        null -> ""
    }
}

fun test_6(x: Base?) {
    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        is Base.A -> ""
        is Base.B -> ""
    }

    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        is Base.A -> ""
        null -> ""
    }
}

fun test_7(x: IBase?) {
    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        is IBase.A -> ""
        is IBase.B -> ""
    }
    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        is IBase.A -> ""
        null -> ""
    }
}

fun test_8(x: Boolean?) {
    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        true -> ""
        false -> ""
    }

    <!NON_EXHAUSTIVE_WHEN_STATEMENT!>when<!> (x) {
        true -> ""
        null -> ""
    }
}

fun test_8_1(x: Boolean?): String {
    return <!NO_ELSE_IN_WHEN!>when<!> (x) {
        true -> ""
        null -> ""
    }
}

// ------------------ with else ------------------

fun test_9(x: SomeEnum?) {
    when (x) {
        SomeEnum.A -> ""
        else -> ""
    }
}

fun test_10(x: Base?) {
    when (x) {
        is Base.A -> ""
        else -> ""
    }
}

fun test_11(x: IBase?) {
    when (x) {
        is IBase.A -> ""
        else -> ""
    }
}

fun test_12(x: Boolean?) {
    when (x) {
        true -> ""
        else -> ""
    }
}

fun test_12_1(x: Boolean?): String {
    return when (x) {
        true -> ""
        else -> ""
    }
}

// ------------------ exhaustive ------------------

fun test_13(x: SomeEnum?) {
    when (x) {
        SomeEnum.A -> ""
        SomeEnum.B -> ""
        null -> ""
    }
}

fun test_14(x: Base?) {
    when (x) {
        is Base.A -> ""
        is Base.B -> ""
        null -> ""
    }
}

fun test_15(x: IBase?) {
    when (x) {
        is IBase.A -> ""
        is IBase.B -> ""
        null -> ""
    }
}

fun test_16(x: Boolean?) {
    when (x) {
        true -> ""
        false -> ""
        null -> ""
    }
}
