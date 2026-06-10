package com.haidang.validatemusic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được quá 800 ký tự")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\s]+$", message = "Tên bài hát không chứa ký tự đặc biệt")
    private String songName;

    @NotBlank(message = "Nghệ sĩ không được để trống")
    @Size(max = 300, message = "Tên nghệ sĩ không đưỡc vượt quá 300 ký tự")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\s]+$", message = "Tên nghệ sĩ không chứa ký tự đặc biệt")
    private String artist;

    @NotBlank(message = "Thể loại nhạc không được bỏ trống")
    @Size(max = 1000, message = "Thể loại nhạc không vượt quá 1000 ký tự")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\s,]+$", message = "Thể loại nhạc chỉ được chứa chữ, số, khoảng trắng và dấu phẩy")
    private String genre;
}
