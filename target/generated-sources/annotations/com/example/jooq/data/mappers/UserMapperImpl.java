package com.example.jooq.data.mappers;

import com.example.jooq.data.dtos.user.UserDTO;
import com.example.jooq.data.entity.User;
import com.example.jooq.data.request.user.UserRequest;
import com.example.jooq.data.response.user.UserResponse;
import com.example.jooq.generated.tables.records.UsersRecord;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T08:39:45+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UsersRecord usersRecord) {
        if ( usersRecord == null ) {
            return null;
        }

        User user = new User();

        user.setId( usersRecord.getId() );
        user.setCreatedAt( usersRecord.getCreatedAt() );
        user.setUpdatedAt( usersRecord.getUpdatedAt() );
        user.setName( usersRecord.getName() );
        user.setEmail( usersRecord.getEmail() );
        user.setPhone( usersRecord.getPhone() );
        user.setAddress( usersRecord.getAddress() );

        return user;
    }

    @Override
    public UsersRecord toRecord(User user) {
        if ( user == null ) {
            return null;
        }

        UsersRecord usersRecord = new UsersRecord();

        usersRecord.setId( user.getId() );
        usersRecord.setCreatedAt( user.getCreatedAt() );
        usersRecord.setUpdatedAt( user.getUpdatedAt() );
        usersRecord.setAddress( user.getAddress() );
        usersRecord.setEmail( user.getEmail() );
        usersRecord.setName( user.getName() );
        usersRecord.setPhone( user.getPhone() );

        return usersRecord;
    }

    @Override
    public UserResponse toDto(UsersRecord usersRecord) {
        if ( usersRecord == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setName( usersRecord.getName() );
        userResponse.setEmail( usersRecord.getEmail() );
        userResponse.setPhone( usersRecord.getPhone() );
        userResponse.setAddress( usersRecord.getAddress() );

        return userResponse;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setPhone( userDTO.getPhone() );
        user.setAddress( userDTO.getAddress() );

        return user;
    }

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPhone( user.getPhone() );
        userDTO.setAddress( user.getAddress() );

        return userDTO;
    }

    @Override
    public User toEntity(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User user = new User();

        user.setName( userRequest.getName() );
        user.setEmail( userRequest.getEmail() );
        user.setPhone( userRequest.getPhone() );
        user.setAddress( userRequest.getAddress() );

        return user;
    }

    @Override
    public UserRequest toRequestDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserRequest.UserRequestBuilder userRequest = UserRequest.builder();

        userRequest.name( user.getName() );
        userRequest.email( user.getEmail() );
        userRequest.phone( user.getPhone() );
        userRequest.address( user.getAddress() );

        return userRequest.build();
    }

    @Override
    public User partialUpdate(UserRequest userRequest, User user) {
        if ( userRequest == null ) {
            return user;
        }

        if ( userRequest.getName() != null ) {
            user.setName( userRequest.getName() );
        }
        if ( userRequest.getEmail() != null ) {
            user.setEmail( userRequest.getEmail() );
        }
        if ( userRequest.getPhone() != null ) {
            user.setPhone( userRequest.getPhone() );
        }
        if ( userRequest.getAddress() != null ) {
            user.setAddress( userRequest.getAddress() );
        }

        return user;
    }
}
