package com.melita.ordertakingapi.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Builder
@NoArgsConstructor @AllArgsConstructor
public class V1OrderCreateRequest {

    @Valid
    public OrderCustomer customer;
    @NotNull
    @Pattern(regexp = "^[0-9-/]{1,50}$")
    public String dateInstallation;
    @NotNull
    @Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")
    public String timeInstallation;
    @NotEmpty
    @NotNull
    public List<Integer> productCategoryIds;

    @AllArgsConstructor @NoArgsConstructor
    @Builder
    @ToString
    public static class OrderCustomer {
        @NotNull(message = "Mandatory")
        public String name;
        @Email(message = "Invalid format")
        public String email;
        @NotNull(message = "Mandatory")
        public String phone;
        @NotNull(message = "Mandatory")
        public String street;
        @NotNull(message = "Mandatory")
        public String streetAdditional;
        @NotNull(message = "Mandatory")
        public String zip;
        @NotNull(message = "Mandatory")
        public String city;
        @NotNull(message = "Mandatory")
        public String country;
    }
}
