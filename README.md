Doclava-Rebirth
=======

Doclava is a very recent, yet currently abandoned Javadoc Doclet written by Google and officially
used for generating Android Developer Documentation as seen
[here](https://developer.android.com/reference).

It provides clear and efficient searching of documented classes, release version filtering,
granular exclusion of classes, fields, and methods using the `@hide` annotation, and
custom styling of documentation components using [ClearSilver](http://www.clearsilver.net)
templates.

This current project originated from the now defunct
[Google Code](https://code.google.com/p/doclava) project and was
directly forked from this GitHub [project](https://github.com/wf2030/doclava).

Doclava-Rebirth aims to update the existing Doclava code to support Java 8, as well as
keep it in line with the current
[AOSP Project](https://android.googlesource.com/platform/external/doclava) repo. There has been no
updates since version 1.0.6, released on January 3, 2014. This is an attempt to continue with that
process under a different name.
As a result, it will revive this once regularly updated project with new releases based on the
current work that Google is performing on the AOSP version.

## How to Build
The [official site](https://code.google.com/p/doclava) offers binary downloads.
However, you can download non-official but regularly updated releases from
[here](https://github.com/diegotori/doclava/releases). Eventually, releases will be deployed to
[Bintray JCenter](https://bintray.com/bintray/jcenter) for convenient use within your
Maven/Gradle projects.

We use [Gradle](http://www.gradle.org/) (via standalone wrapper) to build this project:

    ./gradlew clean assemble publishToMavenLocal

This will build a jar which will be installed to your development environment's local Maven
repo. All installed artifacts can be found in your `build` directory under `build/libs` and
`build/poms`.

However, if you want a statically linked binary version of this library (ideal for standalone use
without Maven), run the following command:

     ./gradlew clean fatJar

This will build a jar located in `build/fat-jar`.

If you want to build both within a single directory (such as for uploading to a private Maven repo),
run the following command:

     ./gradlew clean assemble createStandaloneArtifacts

This will save the Maven artifacts and fat JAR in `build/standalone-dist`.

Once you have the artifact, run the `javadoc` command with the `-doclet` and `-docletpath`
(if not in the classpath) options to generate Javadocs, for example:


    javadoc -encoding UTF-8 -sourcepath src -d docs -subpackages project.package
        -doclet com.google.doclava.Doclava -docletpath /path/to/doclavaJar
        -generatesources -project.name MyProject


For more details, please refer to the [official site](https://code.google.com/p/doclava).

## Future Plans
* Deploying new releases to [Bintray JCenter](https://bintray.com/bintray/jcenter).
* Integrating the current master branch code from the current
[AOSP project](https://android.googlesource.com/platform/external/doclava), which replaces
XML-based federated docs with text file versions as per current AOSP standard.
* Creating a Wiki section for this project detailing how to effectively use Doclava's currently
un-documented features.
* Porting over Wiki pages from the now-defunct Google Code project.

Credit goes to [kwf2030](https://github.com/kwf2030) for laying the initial groundwork for
this fork, and to Google for creating such a powerful alternative to plain old Javadoc.