package net.haesleinhuepf.clij.macro;

import net.imagej.ImageJ;
import org.scijava.Context;

import java.io.*;

public class FallBackCLIJMacroServiceGenerator {
    public static void main(String... args) throws IOException {

        CLIJMacroPluginService cmps = new Context(CLIJMacroPluginService.class).getService(CLIJMacroPluginService.class);

        StringBuilder builder = new StringBuilder();
        builder.append("package net.haesleinhuepf.clij.macro;\n");
        builder.append("import net.haesleinhuepf.clij.macro.modules.*;\n");

        builder.append("// this is generated code. See src/test/java/net/haesleinhuepf/clij/macro for details\n");
        builder.append("public class FallBackCLIJMacroPluginServiceInitializer {\n");
        builder.append("   public static void initialize(FallBackCLIJMacroPluginService service) {\n");


        for (String methodName : cmps.getCLIJMethodNames()) {
            System.out.println(methodName);
            String classname = cmps.getCLIJMacroPlugin(methodName).getClass().getSimpleName();
            builder.append("       service.registerPlugin(\"" + methodName + "\" ," + classname + ".class);\n");
        }
        builder.append("   }\n");
        builder.append("}\n");

        File outputTarget = new File("src/main/java/net/haesleinhuepf/clij/macro/FallBackCLIJMacroPluginServiceInitializer.java");

        FileWriter writer = new FileWriter(outputTarget);
        writer.write(builder.toString());
        writer.close();

    }

}
