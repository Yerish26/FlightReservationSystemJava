package com.aua.flightreservationsystem.persistence.repository.admin;

import com.aua.flightreservationsystem.core.admin.Admin;
import com.aua.flightreservationsystem.persistence.model.AdminEntity;
import com.aua.flightreservationsystem.persistence.model.UserEntity;
import com.aua.flightreservationsystem.persistence.repository.user.UserEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class AdminEntityMapper {
    private final UserEntityMapper userEntityMapper;

    public AdminEntityMapper(UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
    }

    public Admin map(AdminEntity adminEntity) {
        return Admin.builder()
                .id(adminEntity.getId())
                .roleInCompany(adminEntity.getRoleInCompany())
                .user(userEntityMapper.map(adminEntity.getUser()))
                .build();
    }

    public AdminEntity map(Admin admin) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setId(admin.getId());
        adminEntity.setRoleInCompany(admin.getRoleInCompany());
        adminEntity.setUser(userEntityMapper.map(admin.getUser()));
        return adminEntity;
    }
}
