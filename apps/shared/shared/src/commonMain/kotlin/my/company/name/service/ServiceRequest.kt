package my.company.name.service

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import my.company.name.base.ResponseException
import my.company.name.service.impl.GetRequest

/**
 * Get platform client
 */
expect fun httpClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient

/**
 * Common service network
 */
class ServiceRequest {
    companion object {
        /**
         * GitLab URL
         */
        const val URL = "https://api.github.com/";
    }

    private val json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
    }

    private var httpClient = httpClient {

        expectSuccess = false

        HttpResponseValidator {
            validateResponse { response ->
                if (response.status != HttpStatusCode.OK) {
                    throw ResponseException(
                        code = response.status.value,
                        error = "Error KM js client"
                    )
                }
            }
        }

        install(DefaultRequest) {
            url(URL)
            contentType(ContentType.Application.Json)
        }

        install(ContentNegotiation) {
            json(json)
        }
    }

    val get = GetRequest(httpClient)
}
