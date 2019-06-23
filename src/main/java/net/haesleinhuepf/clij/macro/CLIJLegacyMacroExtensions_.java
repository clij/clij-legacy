package net.haesleinhuepf.clij.macro;

import ij.IJ;
import ij.plugin.PlugIn;
import net.haesleinhuepf.clij.converters.FallBackCLIJConverterService;

/**
 *
 * Author: @haesleinhuepf
 * June 2019
 */
public class CLIJLegacyMacroExtensions_ implements PlugIn {

    @Override
    public void run(String s) {
        CLIJMacroExtensions cme = new CLIJMacroExtensions();
        cme.clijConverterService = new FallBackCLIJConverterService();

        CLIJHandler.getInstance().setPluginService(new FallBackCLIJMacroPluginService());

        cme.run();
    }
}