package com.example.online_store_project.OnlineStoreProject.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String country;
    private String city;
    private String street;
    private String zipCode;
}
