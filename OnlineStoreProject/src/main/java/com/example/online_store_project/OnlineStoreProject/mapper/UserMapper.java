package com.example.online_store_project.OnlineStoreProject.mapper;

import com.example.online_store_project.OnlineStoreProject.dto.AddressDTO;
import com.example.online_store_project.OnlineStoreProject.dto.request.UserRequestDTO;
import com.example.online_store_project.OnlineStoreProject.dto.response.UserResponseDTO;
import com.example.online_store_project.OnlineStoreProject.entity.Address;
import com.example.online_store_project.OnlineStoreProject.entity.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setAvatar(dto.getAvatar());
        user.setMessageChannel(dto.getMessageChannel());
        user.setRole(dto.getRole());

        if (dto.getAddress() != null) {
            Address address = new Address();
            address.setCountry(dto.getAddress().getCountry());
            address.setCity(dto.getAddress().getCity());
            address.setStreet(dto.getAddress().getStreet());
            address.setZipCode(dto.getAddress().getZipCode());
            user.setAddress(address);
        }
        return user;
    }

    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setAvatar(user.getAvatar());
        dto.setMessageChannel(user.getMessageChannel());
        dto.setRole(user.getRole());

        if (user.getAddress() != null) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setCountry(user.getAddress().getCountry());
            addressDTO.setCity(user.getAddress().getCity());
            addressDTO.setStreet(user.getAddress().getStreet());
            addressDTO.setZipCode(user.getAddress().getZipCode());
            dto.setAddress(addressDTO);
        }
        return dto;
    }
}
