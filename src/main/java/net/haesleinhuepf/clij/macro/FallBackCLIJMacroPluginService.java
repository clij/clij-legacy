package net.haesleinhuepf.clij.macro;

import ij.IJ;
import ij.macro.ExtensionDescriptor;
import ij.macro.MacroExtension;

import java.util.HashMap;
import java.util.Set;

public class FallBackCLIJMacroPluginService extends CLIJMacroPluginService {

    public FallBackCLIJMacroPluginService() {
        FallBackCLIJMacroPluginServiceInitializer.initialize(this);
    }

    HashMap<String, Class> pluginClassMap = new HashMap<String, Class>();

    public void registerPlugin(String methodName, Class pluginClass) {
        pluginClassMap.put(methodName, pluginClass);
    }

    @Override
    public void initialize() {}

    public Set<String> getCLIJMethodNames() {
        return pluginClassMap.keySet();
    }

    public CLIJMacroPlugin getCLIJMacroPlugin(final String name) {
        Class<CLIJMacroPlugin> klass = pluginClassMap.get(name);

        if (klass == null) {
            return null;
        }

        try {
            return klass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExtensionDescriptor getPluginExtensionDescriptor(String name){
        final CLIJMacroPlugin plugin = getCLIJMacroPlugin(name);

        String[] parameters = plugin.getParameterHelpText().split(",");
        int[] parameterTypes = new int[0];

        if (parameters.length > 1 || parameters[0].length() > 0) {
            parameterTypes = new int[parameters.length];
            int i = 0;
            for (String parameter : parameters) {
                if (parameter.trim().startsWith("Image")) {
                    parameterTypes[i] = MacroExtension.ARG_STRING;
                } else if (parameter.trim().startsWith("String")) {
                    parameterTypes[i] = MacroExtension.ARG_STRING;
                } else {
                    parameterTypes[i] = MacroExtension.ARG_NUMBER;
                }
                i++;
            }
        }
        return new ExtensionDescriptor(name, parameterTypes, CLIJHandler.getInstance());
    }

    @Override
    public Class<CLIJMacroPlugin> getPluginType() {
        return CLIJMacroPlugin.class;
    }

    public String getNameByClass(Class<? extends AbstractCLIJPlugin> aClass) {
        for (String name : getCLIJMethodNames()) {
            if (getCLIJMacroPlugin(name).getClass() == aClass) {
                return name;
            }
        }
        return null;
    }

}
