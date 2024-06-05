package com.ashu.user.service.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {

	private String message;
	private Boolean success;
	private HttpStatus status;
	
	
	 // Builder class for ApiResponse
    public static class ApiResponseBuilder {
        private String message;
        private Boolean success;
        private HttpStatus status;

        public ApiResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseBuilder success(Boolean success) {
            this.success = success;
            return this;
        }

        public ApiResponseBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiResponse build() {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.message = this.message;
            apiResponse.success = this.success;
            apiResponse.status = this.status;
            return apiResponse;
        }
    }

    // Static method to obtain a builder instance
    public static ApiResponseBuilder builder() {
        return new ApiResponseBuilder();
    }

}
