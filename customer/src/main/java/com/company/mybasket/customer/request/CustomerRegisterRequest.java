package com.company.mybasket.customer.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerRegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
}
