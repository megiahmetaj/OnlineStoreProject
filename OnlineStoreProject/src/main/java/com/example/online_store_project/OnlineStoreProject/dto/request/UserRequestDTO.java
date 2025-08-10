package com.example.online_store_project.OnlineStoreProject.dto.request;

import com.example.online_store_project.OnlineStoreProject.dto.AddressDTO;
import com.example.online_store_project.OnlineStoreProject.enums.MessageChannel;
import com.example.online_store_project.OnlineStoreProject.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    @Email
    @NotNull
    private String email;
    @NotNull
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    private AddressDTO address;
    private String avatar;
    private Role role;
    private MessageChannel messageChannel;
}
