package ra.edu.ss11.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.edu.ss11.dto.ApiResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // [Bài 4] Bắt mọi Exception hệ thống (Lỗi 500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleAllExceptions(Exception e) {
        // Ghi lại đầy đủ Stack Trace ra Console và File log
        log.error("Lỗi hệ thống xảy ra: ", e);

        // Trả về ApiResponse che giấu lỗi chi tiết khỏi Client
        ApiResponse<String> response = new ApiResponse<>(
                "Đã xảy ra lỗi nội bộ hệ thống. Vui lòng liên hệ quản trị viên!",
                false,
                null
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}