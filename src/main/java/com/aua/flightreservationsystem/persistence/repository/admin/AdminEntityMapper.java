package com.aua.flightreservationsystem.persistence.repository.admin;

import com.aua.flightreservationsystem.core.admin.Admin;
import com.aua.flightreservationsystem.persistence.model.AdminEntity;
import com.aua.flightreservationsystem.persistence.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class AdminEntityMapper {
    public Admin map(AdminEntity adminEntity) {
        return Admin.builder()
                .id(adminEntity.getId())
                .roleInCompany(adminEntity.getRoleInCompany())
                .userId(adminEntity.getUser().getId())
                .build();
    }


    public AdminEntity map(Admin admin) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setId(admin.getId());
        adminEntity.setRoleInCompany(admin.getRoleInCompany());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(admin.getUserId());
        adminEntity.setUser(userEntity);

        return adminEntity;
    }
}
