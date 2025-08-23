package com.example.online_store_project.OnlineStoreProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String country;
    private String city;
    private String street;
    private String zipCode;

}
