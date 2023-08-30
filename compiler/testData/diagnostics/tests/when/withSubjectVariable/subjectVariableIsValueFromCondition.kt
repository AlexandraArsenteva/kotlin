// FIR_IDENTICAL
// !LANGUAGE: +VariableDeclarationInWhenSubject
// !DIAGNOSTICS: +UNUSED_VARIABLE

fun test() {
    when (val <!UNUSED_VARIABLE!>x<!> = 10) {
        10 -> {}
        11 -> {}
    }
}