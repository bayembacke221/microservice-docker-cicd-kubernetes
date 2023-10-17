package com.example.serviceadmission.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

public enum TypeResultat {
    ABSENT("absent"),
    NON_ADMIS("non-admis"),
    ADMIS("admis");
    @Getter
    @Setter
    @JsonValue
    private String value;

    TypeResultat(String value) {
        this.value = value;
    }

}
