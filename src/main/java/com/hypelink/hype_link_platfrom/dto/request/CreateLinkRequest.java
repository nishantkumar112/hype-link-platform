package com.hypelink.hype_link_platfrom.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateLinkRequest {
    @NotBlank(message = "Original URL is required")
    @URL(message = "Invalid URL format")
    private String originalUrl;

    @NotNull(message = "createdBy is required")
    private Long createdBy;
    private LocalDateTime expiryAt;
}
