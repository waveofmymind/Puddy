package world.puddy.common.error

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import world.puddy.common.error.exception.BusinessException
import world.puddy.common.error.exception.DuplicateRegisterException
import world.puddy.common.error.exception.InvalidPasswordException
import world.puddy.common.error.exception.UserNotFoundException
import world.puddy.common.response.Response

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun businessException(e: BusinessException): ResponseEntity<Response<Nothing?>> {
        return ResponseEntity.status(e.errorCode.httpStatus).body(Response.fail(e.errorCode))
    }

    @ExceptionHandler(DuplicateRegisterException::class)
    fun duplicateRegisterException(e: DuplicateRegisterException): ResponseEntity<Response<Nothing?>> {
        return ResponseEntity.status(e.errorCode.httpStatus).body(Response.fail(e.errorCode))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<Response<Nothing?>> {
        val errorCode = ErrorCode.INVALID_INPUT_VALUE
        return ResponseEntity.status(errorCode.httpStatus).body(Response.fail(errorCode))
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun notFoundException(e: UserNotFoundException): ResponseEntity<Response<Nothing?>> {
        return ResponseEntity.status(e.errorCode.httpStatus).body(Response.fail(e.errorCode))
    }

    @ExceptionHandler(InvalidPasswordException::class)
    fun invalidPasswordException(e: InvalidPasswordException): ResponseEntity<Response<Nothing?>> {
        return ResponseEntity.status(e.errorCode.httpStatus).body(Response.fail(e.errorCode))
    }
}
