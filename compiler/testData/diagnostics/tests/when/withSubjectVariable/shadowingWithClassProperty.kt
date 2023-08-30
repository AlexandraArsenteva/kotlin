// FIR_IDENTICAL
// !LANGUAGE: +VariableDeclarationInWhenSubject
// !DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER

class A(val b: Int) {
    fun testShadowingClassProperty() {
        when (val b = b) {
            1 -> this@A.b
            else -> b
        }
    }
}