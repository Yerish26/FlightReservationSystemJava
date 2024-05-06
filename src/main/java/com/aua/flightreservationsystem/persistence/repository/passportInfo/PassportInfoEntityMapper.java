package com.aua.flightreservationsystem.persistence.repository.passportInfo;

import com.aua.flightreservationsystem.core.passportInfo.PassportInfo;
import com.aua.flightreservationsystem.persistence.model.PassportInfoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportInfoEntityMapper {
    PassportInfo map(PassportInfoEntity passportInfoEntity);

    PassportInfoEntity map(PassportInfo passportInfo);
}
