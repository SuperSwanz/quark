package com.quarakus.sample.configuration;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import java.util.Optional;

public class Cookie {
    @Inject
    @ConfigProperty(name = "quark.security.cookie.domain")
    Optional<String> domain;

    @Inject
    @ConfigProperty(name = "quark.security.cookie.isRequired")
    private Boolean isRequired;

    @Inject
    @ConfigProperty(name = "quark.security.cookie.name", defaultValue = "quark-auth")
    private String name;

    @Inject
    @ConfigProperty(name = "quark.security.cookie.isSecure")
    private Boolean isSecure;

    @Inject
    @ConfigProperty(name = "quark.security.cookie.isHttpOnly")
    private Boolean isHttpOnly;

    @Inject
    @ConfigProperty(name = "quark.security.cookie.maxAge")
    private Long maxAge;

    @Inject
    @ConfigProperty(name = "quark.security.cookie.path")
    private String path;

    public Optional<String> getDomain() {
        return domain;
    }

    public void setDomain(Optional<String> domain) {
        this.domain = domain;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSecure() {
        return isSecure;
    }

    public void setSecure(Boolean secure) {
        isSecure = secure;
    }

    public Boolean getHttpOnly() {
        return isHttpOnly;
    }

    public void setHttpOnly(Boolean httpOnly) {
        isHttpOnly = httpOnly;
    }

    public Long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Long maxAge) {
        this.maxAge = maxAge;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
