package com.gkcorex.catalyst.ai.mappers;

import com.gkcorex.catalyst.ai.dtos.auth.SignUpRequest;
import com.gkcorex.catalyst.ai.dtos.auth.UserProfileResponse;
import com.gkcorex.catalyst.ai.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User mapSignUpRequestToEntity(SignUpRequest signUpRequest);

  UserProfileResponse mapEntityToUserProfileResponse(User user);
}
