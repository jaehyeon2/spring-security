package com.example.springsecurity.domain;

import com.example.springsecurity.dto.MemberSignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    private String email;

    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Member(MemberSignupRequestDto request){
        email = request.getEmail();
        password = request.getPassword();
        name = request.getName();
        role = Role.USER;
    }

    public void encryptPassword(PasswordEncoder passwordEncoder){
        password = passwordEncoder.encode(password);
    }
}
