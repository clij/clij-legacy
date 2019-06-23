import ij.IJ;
import ij.plugin.PlugIn;
import net.haesleinhuepf.clij.macro.CLIJLegacyMacroExtensions_;


/**
 *
 * Author: @haesleinhuepf
 * June 2019
 */
public class CLIJLegacyMacroExtensions implements PlugIn {

    @Override
    public void run(String s) {
        new CLIJLegacyMacroExtensions_().run("");
    }
}