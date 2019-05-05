package com.ibm.openwhisk.micronaut.jpa.sample;

import javax.validation.constraints.NotNull;

public interface ApplicationConfiguration {

    @NotNull Integer getMax();
}
