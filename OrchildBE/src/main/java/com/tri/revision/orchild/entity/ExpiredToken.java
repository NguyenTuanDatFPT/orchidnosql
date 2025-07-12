package com.tri.revision.orchild.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "expired_tokens")
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ExpiredToken {
    @Id
    private String id;
    private Instant expiredAt;
}
