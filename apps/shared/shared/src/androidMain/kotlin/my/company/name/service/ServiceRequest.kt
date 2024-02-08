package my.company.name.service

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient {
    config(this)
}
