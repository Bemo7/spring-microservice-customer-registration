package com.bemojr.fraud.dto;

import lombok.Builder;

@Builder
public record FraudCheckResponse(boolean isFraudster) {
}
