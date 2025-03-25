package com.example.infoservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

@Builder
public record Member(
        @Id
        Long id,
        @NotBlank(message = "The Member ID must be defined.")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The Member ID format must be valid."
        )
        String memberId,

        @NotBlank(message = "The Member Name must be defined.")
        String memberName,
        @NotBlank(message = "The Phone Number must be defined.")
        String phoneNumber,
        @Column("create_at")
        @CreatedDate
        Instant createAt,
        @Column("last_modified_at")
        @LastModifiedDate
        Instant lastModifiedAt,
        @Version
        int version

) {
}
