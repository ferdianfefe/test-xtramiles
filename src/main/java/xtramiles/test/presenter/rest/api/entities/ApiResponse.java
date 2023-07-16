package xtramiles.test.presenter.rest.api.entities;

import lombok.Value;

@Value
public class ApiResponse {
    private final Boolean success;
    private final String message;

    public static ApiResponse from(Boolean success, String message) {
        return new ApiResponse(success, message);
    }
}
