// package com.example.demo.exception;

// import com.example.demo.dto.ApiResponse;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// import java.time.LocalDateTime;
// import java.util.HashMap;
// import java.util.Map;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
//         Map<String, Object> response = new HashMap<>();
//         response.put("success", false);
//         response.put("message", ex.getMessage());
//         response.put("timestamp", LocalDateTime.now());
//         response.put("status", HttpStatus.NOT_FOUND.value());
//         return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler({IllegalArgumentException.class, BadRequestException.class})
//     public ResponseEntity<Map<String, Object>> handleBadRequestException(RuntimeException ex) {
//         Map<String, Object> response = new HashMap<>();
//         response.put("success", false);
//         response.put("message", ex.getMessage());
//         response.put("timestamp", LocalDateTime.now());
//         response.put("status", HttpStatus.BAD_REQUEST.value());
//         return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(IllegalStateException.class)
//     public ResponseEntity<Map<String, Object>> handleIllegalStateException(IllegalStateException ex) {
//         Map<String, Object> response = new HashMap<>();
//         response.put("success", false);
//         response.put("message", ex.getMessage());
//         response.put("timestamp", LocalDateTime.now());
//         response.put("status", HttpStatus.BAD_REQUEST.value());
//         return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
//         Map<String, Object> response = new HashMap<>();
//         response.put("success", false);
//         response.put("message", "Internal server error");
//         response.put("timestamp", LocalDateTime.now());
//         response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
//         return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }