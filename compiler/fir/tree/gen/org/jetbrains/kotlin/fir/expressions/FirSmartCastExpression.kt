/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.expressions

import org.jetbrains.kotlin.KtSourceElement
import org.jetbrains.kotlin.fir.FirElement
import org.jetbrains.kotlin.fir.types.ConeKotlinType
import org.jetbrains.kotlin.fir.types.FirTypeRef
import org.jetbrains.kotlin.types.SmartcastStability
import org.jetbrains.kotlin.fir.visitors.*

/*
 * This file was generated automatically
 * DO NOT MODIFY IT MANUALLY
 */

abstract class FirSmartCastExpression : FirExpression() {
    abstract override val source: KtSourceElement?
    abstract override val coneTypeOrNull: ConeKotlinType?
    abstract override val annotations: List<FirAnnotation>
    abstract val originalExpression: FirExpression
    abstract val typesFromSmartCast: Collection<ConeKotlinType>
    abstract val smartcastType: FirTypeRef
    abstract val smartcastTypeWithoutNullableNothing: FirTypeRef?
    abstract val isStable: Boolean
    abstract val smartcastStability: SmartcastStability

    override fun <R, D> accept(visitor: FirVisitor<R, D>, data: D): R = visitor.visitSmartCastExpression(this, data)

    @Suppress("UNCHECKED_CAST")
    override fun <E : FirElement, D> transform(transformer: FirTransformer<D>, data: D): E =
        transformer.transformSmartCastExpression(this, data) as E

    abstract override fun replaceConeTypeOrNull(newConeTypeOrNull: ConeKotlinType?)

    abstract override fun replaceAnnotations(newAnnotations: List<FirAnnotation>)

    abstract fun replaceOriginalExpression(newOriginalExpression: FirExpression)

    abstract override fun <D> transformAnnotations(transformer: FirTransformer<D>, data: D): FirSmartCastExpression

    abstract fun <D> transformOriginalExpression(transformer: FirTransformer<D>, data: D): FirSmartCastExpression
}
