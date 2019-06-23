package net.haesleinhuepf.clij.macro;

import org.junit.Ignore;
import org.junit.Test;

public class ExtensionsTest {
    @Ignore
    @Test
    public void testExtensionsRegistration() {
        new CLIJLegacyMacroExtensions_().run("");

        CLIJHandler.getInstance().getExtensionFunctions();
    }
}
