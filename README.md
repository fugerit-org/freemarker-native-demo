# freemarker-native-demo

Demo application for [FreeMarker Native](https://github.com/fugerit-org/freemarker-native) project, based on [Quarkus](https://quarkus.io/).

## Quickstart

Requirements : 

* GraalVM 21+

1. Build

```shell
./gradlew build -Dquarkus.native.enabled=true -Dquarkus.package.jar.enabled=false
```

2. Run

```shell
./build/freemarker-native-demo-*-runner 
```

3. Test

<http://localhost:8080/hello/freemarker>

## Configuration

There are the operations we did to configure this project native build : 

1. Added dependency "org.fugerit.java:freemarker-native"
2. Configured additional build args -H:IncludeResources
3. Configured reflection for beans (with annotation @RegisterForReflection)

## Original Quarkus README

From here on you can find the README generated from the Quarkus Launcher : 

<https://code.quarkus.io/?g=org.fugerit.java.demo&a=freemarker-native-demo&b=GRADLE_KOTLIN_DSL&e=rest>

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./gradlew build -Dquarkus.native.enabled=true -Dquarkus.package.jar.enabled=false
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./gradlew build -Dquarkus.native.enabled=true -Dquarkus.native.container-build=true -Dquarkus.package.jar.enabled=false
```

You can then execute your native executable with: `./build/freemarker-native-demo-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/gradle-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
