/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.backend.js.lower.serialization.ir

import org.jetbrains.kotlin.backend.common.serialization.CompatibilityMode
import org.jetbrains.kotlin.backend.common.serialization.DeclarationTable
import org.jetbrains.kotlin.backend.common.serialization.IdSignatureClashTracker
import org.jetbrains.kotlin.backend.common.serialization.IrModuleSerializer
import org.jetbrains.kotlin.config.LanguageVersionSettings
import org.jetbrains.kotlin.ir.IrBuiltIns
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.ir.util.IrMessageLogger

class JsIrModuleSerializer(
    messageLogger: IrMessageLogger,
    irBuiltIns: IrBuiltIns,
    compatibilityMode: CompatibilityMode,
    normalizeAbsolutePaths: Boolean,
    sourceBaseDirs: Collection<String>,
    private val languageVersionSettings: LanguageVersionSettings,
    shouldCheckSignaturesOnUniqueness: Boolean = true
) : IrModuleSerializer<JsIrFileSerializer>(messageLogger, compatibilityMode, normalizeAbsolutePaths, sourceBaseDirs) {

    private val globalDeclarationTable = JsGlobalDeclarationTable(
        irBuiltIns,
        if (shouldCheckSignaturesOnUniqueness) JsUniqIdClashTracker() else IdSignatureClashTracker.DEFAULT_TRACKER
    )

    override fun createSerializerForFile(file: IrFile): JsIrFileSerializer =
        JsIrFileSerializer(
            messageLogger,
            DeclarationTable(globalDeclarationTable),
            compatibilityMode = compatibilityMode,
            normalizeAbsolutePaths = normalizeAbsolutePaths,
            sourceBaseDirs = sourceBaseDirs,
            languageVersionSettings = languageVersionSettings,
        )
}