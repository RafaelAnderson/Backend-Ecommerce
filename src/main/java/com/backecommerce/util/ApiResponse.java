package com.backecommerce.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private Boolean error;
    private Object data;

    public static ApiResponse ok(String mensaje, Object data) {
        return load(false, mensaje, data);
    }

    public static ApiResponse load(boolean isError, String mensaje, Object data) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setError(isError);
        apiResponse.setMessage(mensaje);
        apiResponse.setData(data);
        return apiResponse;
    }
}
