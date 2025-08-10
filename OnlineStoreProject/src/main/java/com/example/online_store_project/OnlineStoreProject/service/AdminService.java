package com.example.online_store_project.OnlineStoreProject.service;

import com.example.online_store_project.OnlineStoreProject.entity.Admin;
import com.example.online_store_project.OnlineStoreProject.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found with id: " + id));
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        Admin existing = getAdminById(id);
        existing.setFirstName(updatedAdmin.getFirstName());
        existing.setLastName(updatedAdmin.getLastName());
        return adminRepository.save(existing);
    }

    public void deleteAdmin(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new EntityNotFoundException("Admin not found with id: " + id);
        }
        adminRepository.deleteById(id);
    }
}
