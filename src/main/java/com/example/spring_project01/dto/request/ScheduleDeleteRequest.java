package com.example.spring_project01.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleDeleteRequest {

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

}
