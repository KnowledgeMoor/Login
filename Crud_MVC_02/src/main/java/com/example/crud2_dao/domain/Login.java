package com.example.crud2_dao.domain;

import java.util.List;

import org.springframework.data.convert.ReadingConverter;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Login {

@NonNull
private String usuario;
@NonNull
private String senha;

private List<Role> roles;

}
