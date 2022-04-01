package vn.namnp.domain.utils

import java.io.Serializable

sealed class Result<T>(val data: T? = null, val message: String? = null) : Serializable {
    class Loading<T>(data: T? = null) : Result<T>(data)
    class Success<T>(data: T) : Result<T>(data)
    class Error<T>(data: T? = null, message: String) : Result<T>(data, message)
}