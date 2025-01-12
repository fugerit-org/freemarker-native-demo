package org.fugerit.java.demo;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class HelloDataModel {

    private String name;

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
