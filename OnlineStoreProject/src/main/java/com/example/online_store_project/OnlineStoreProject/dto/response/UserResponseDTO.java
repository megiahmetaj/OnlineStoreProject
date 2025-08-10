package com.example.online_store_project.OnlineStoreProject.dto.response;

import com.example.online_store_project.OnlineStoreProject.dto.AddressDTO;
import com.example.online_store_project.OnlineStoreProject.enums.MessageChannel;
import com.example.online_store_project.OnlineStoreProject.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String email;
    private AddressDTO address;
    private String avatar;
    private Role role;
    private MessageChannel messageChannel;
}
