package com.haidang.validateregister.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name không được để trống")
    @Size(min = 5, max = 50, message = "First name phải từ 5-50 ký tự")
    private String firstName;

    @NotBlank(message = "Last name không được để trống")
    @Size(min = 5, max = 50, message = "Last name phải từ 5-50 ký tự")
    private String lastName;

    @Pattern(
            regexp = "^0\\d{9}$",
            message = "Số điện thoại không hợp lệ"
    )
    private String phoneNumber;

    @Min(value = 18,
            message = "Tuổi phải lớn hơn hoặc bằng 18"
    )
    private Integer age;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    private String email;


}
