package com.tri.revision.orchild.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tri.revision.orchild.enums.Role;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    private String id;

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private boolean isActive;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
