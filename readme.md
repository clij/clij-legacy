## Installation instructions for CLIJ in ImageJ1

In order to make CLIJ run in ImageJ, download the folling jar files, remove the number from their endings and put them in the `plugins/jars/` directory of your ImageJ installation:
* [bridj-0.7.0.jar](https://sites.imagej.net/clij/jars/bridj-0.7.0.jar-20181201213334)
* [clij_1.0.5-BETA.jar](https://github.com/clij/clij/releases/download/1.0.5-BETA/clij-core-1.0.5-BETA.jar)
* [clij-clearcl-0.8.0.jar](https://sites.imagej.net/clij/jars/clij-clearcl-0.8.0.jar-20190115231015)
* [clij-core-1.0.5-BETA.jar](https://github.com/clij/clij/releases/download/1.0.5-BETA/clij-core-1.0.5-BETA.jar)
* [clij-coremen-0.5.0.jar](https://sites.imagej.net/clij/jars/clij-coremem-0.5.0.jar-20190115231015)
* [clij-legacy_-0.1.0.jar](https://github.com/clij/clij-legacy/releases/download/0.1.0/clij-legacy_-0.1.0.jar)
* [imagej-common-0.28.2.jar](https://sites.imagej.net/Java-8/jars/imagej-common-0.28.2.jar-20190516211613)
* [imglib2-5.6.3.jar](https://sites.imagej.net/Java-8/jars/imglib2-5.6.3.jar-20181204141527)
* [imglib2-realtransform-2.1.0.jar](https://sites.imagej.net/Java-8/jars/imglib2-realtransform-2.1.0.jar-20181204141527)
* [jocl-2.0.1-jar](https://sites.imagej.net/clij/jars/jocl-2.0.1.jar-20181201212910)
* [scijava-common-2.77.0-jar](https://sites.imagej.net/Java-8/jars/scijava-common-2.76.1.jar-20181204141527)

### Please note
It is recommended to [use clij from Fiji](https://clij.github.io/clij-docs/installationInFiji). ImageJ1 support is experimental.

### Known issues
* CLIJ doesn't support ImageJ ops in ImageJ1.
* CLIJ is not extensible with CLIJ plugins in ImageJ1.

[Back to CLIJ documentation](https://clij.github.io/)