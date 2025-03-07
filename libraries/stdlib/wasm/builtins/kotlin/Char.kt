/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

// Auto-generated file. DO NOT EDIT!

package kotlin

import kotlin.wasm.internal.*

/** Represents a 16-bit Unicode character. */
@WasmAutoboxed
@Suppress("NOTHING_TO_INLINE")
public class Char private constructor(private val value: Char) : Comparable<Char> {
    /**
     * Compares this value with the specified value for order.
     *
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    @kotlin.internal.IntrinsicConstEvaluation
    public override fun compareTo(other: Char): Int =
        wasm_i32_compareTo(this.code, other.code)

    /** Adds the other Int value to this value resulting a Char. */
    @kotlin.internal.IntrinsicConstEvaluation
    public inline operator fun plus(other: Int): Char =
        (this.code + other).toChar()

    /** Subtracts the other Char value from this value resulting an Int. */
    @kotlin.internal.IntrinsicConstEvaluation
    public inline operator fun minus(other: Char): Int =
        (this.code - other.code)

    /** Subtracts the other Int value from this value resulting a Char. */
    @kotlin.internal.IntrinsicConstEvaluation
    public inline operator fun minus(other: Int): Char =
        (this.code - other).toChar()

    /**
     * Returns this value incremented by one.
     *
     * @sample samples.misc.Builtins.inc
     */
    public inline operator fun inc(): Char =
        (this.code + 1).toChar()

    /**
     * Returns this value decremented by one.
     *
     * @sample samples.misc.Builtins.dec
     */
    public inline operator fun dec(): Char =
        (this.code - 1).toChar()

    /** Creates a range from this value to the specified [other] value. */
    public operator fun rangeTo(other: Char): CharRange =
        CharRange(this, other)

    /**
     * Creates a range from this value up to but excluding the specified [other] value.
     *
     * If the [other] value is less than or equal to `this` value, then the returned range is empty.
     */
    @SinceKotlin("1.9")
    @WasExperimental(ExperimentalStdlibApi::class)
    public operator fun rangeUntil(other: Char): CharRange =
        this until other

    /** Returns the value of this character as a `Byte`. */
    @Deprecated("Conversion of Char to Number is deprecated. Use Char.code property instead.", ReplaceWith("this.code.toByte()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @kotlin.internal.IntrinsicConstEvaluation
    public inline fun toByte(): Byte =
        this.code.toByte()

    /** Returns the value of this character as a `Char`. */
    @kotlin.internal.IntrinsicConstEvaluation
    public inline fun toChar(): Char =
        this

    /** Returns the value of this character as a `Short`. */
    @Deprecated("Conversion of Char to Number is deprecated. Use Char.code property instead.", ReplaceWith("this.code.toShort()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @kotlin.internal.IntrinsicConstEvaluation
    public inline fun toShort(): Short =
        this.code.toShort()

    /** Returns the value of this character as a `Int`. */
    @Deprecated("Conversion of Char to Number is deprecated. Use Char.code property instead.", ReplaceWith("this.code"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @kotlin.internal.IntrinsicConstEvaluation
    @WasmNoOpCast
    public fun toInt(): Int =
        implementedAsIntrinsic

    /** Returns the value of this character as a `Long`. */
    @Deprecated("Conversion of Char to Number is deprecated. Use Char.code property instead.", ReplaceWith("this.code.toLong()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @kotlin.internal.IntrinsicConstEvaluation
    public inline fun toLong(): Long =
        this.code.toLong()

    /** Returns the value of this character as a `Float`. */
    @Deprecated("Conversion of Char to Number is deprecated. Use Char.code property instead.", ReplaceWith("this.code.toFloat()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @kotlin.internal.IntrinsicConstEvaluation
    public inline fun toFloat(): Float =
        this.code.toFloat()

    /** Returns the value of this character as a `Double`. */
    @Deprecated("Conversion of Char to Number is deprecated. Use Char.code property instead.", ReplaceWith("this.code.toDouble()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @kotlin.internal.IntrinsicConstEvaluation
    public inline fun toDouble(): Double =
        this.code.toDouble()

    @kotlin.internal.IntrinsicConstEvaluation
    override fun toString(): String {
        val array = WasmCharArray(1)
        array.set(0, this)
        return array.createString()
    }

    @kotlin.internal.IntrinsicConstEvaluation
    public override fun equals(other: Any?): Boolean {
        if (other is Char)
            return wasm_i32_eq(this.code, other.code)
        return false
    }

    override fun hashCode(): Int =
        this.code.hashCode()

    public companion object {
        /**
         * The minimum value of a character code unit.
         */
        @SinceKotlin("1.3")
        public const val MIN_VALUE: Char = '\u0000'

        /**
         * The maximum value of a character code unit.
         */
        @SinceKotlin("1.3")
        public const val MAX_VALUE: Char = '\uFFFF'

        /**
         * The minimum value of a Unicode high-surrogate code unit.
         */
        public const val MIN_HIGH_SURROGATE: Char = '\uD800'

        /**
         * The maximum value of a Unicode high-surrogate code unit.
         */
        public const val MAX_HIGH_SURROGATE: Char = '\uDBFF'

        /**
         * The minimum value of a Unicode low-surrogate code unit.
         */
        public const val MIN_LOW_SURROGATE: Char = '\uDC00'

        /**
         * The maximum value of a Unicode low-surrogate code unit.
         */
        public const val MAX_LOW_SURROGATE: Char = '\uDFFF'

        /**
         * The minimum value of a Unicode surrogate code unit.
         */
        public const val MIN_SURROGATE: Char = MIN_HIGH_SURROGATE

        /**
         * The maximum value of a Unicode surrogate code unit.
         */
        public const val MAX_SURROGATE: Char = MAX_LOW_SURROGATE

        /**
         * The number of bytes used to represent a Char in a binary form.
         */
        @SinceKotlin("1.3")
        public const val SIZE_BYTES: Int = 2

        /**
         * The number of bits used to represent a Char in a binary form.
         */
        @SinceKotlin("1.3")
        public const val SIZE_BITS: Int = 16

        /**
         * The minimum value of a supplementary code point, `\u0x10000`.
         */
        internal const val MIN_SUPPLEMENTARY_CODE_POINT: Int = 0x10000

        /**
         * The minimum value of a Unicode code point.
         */
        internal const val MIN_CODE_POINT: Int = 0x000000

        /**
         * The maximum value of a Unicode code point.
         */
        internal const val MAX_CODE_POINT: Int = 0X10FFFF

        /**
         * The minimum radix available for conversion to and from strings.
         */
        internal const val MIN_RADIX: Int = 2

        /**
         * The maximum radix available for conversion to and from strings.
         */
        internal const val MAX_RADIX: Int = 36
    }
}
