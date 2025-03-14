/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/low-level-api-fir/testdata/dependentCopy")
@TestDataPath("$PROJECT_ROOT")
public class SourceDependentCopyContextTestGenerated extends AbstractSourceDependentCopyContextTest {
    @Test
    public void testAllFilesPresentInDependentCopy() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testdata/dependentCopy"), Pattern.compile("^(.+)\\.(kt)$"), null, true);
    }

    @Test
    @TestMetadata("class.kt")
    public void testClass() throws Exception {
        runTest("analysis/low-level-api-fir/testdata/dependentCopy/class.kt");
    }

    @Test
    @TestMetadata("classBody.kt")
    public void testClassBody() throws Exception {
        runTest("analysis/low-level-api-fir/testdata/dependentCopy/classBody.kt");
    }

    @Test
    @TestMetadata("function.kt")
    public void testFunction() throws Exception {
        runTest("analysis/low-level-api-fir/testdata/dependentCopy/function.kt");
    }
}
