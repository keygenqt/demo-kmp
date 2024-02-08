package my.company.name.service.impl

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import my.company.name.models.RepoModel

class GetRequest(private val client: HttpClient) {

    companion object {
        /**
         * GitLab path org
         */
        const val USER = "keygenqt";
    }

    /**
     * Get list projects
     */
    @Throws(Exception::class)
    suspend fun repos(): List<RepoModel> {
        return client.get("users/$USER/repos") {
            url {
                parameters.append("sort", "created")
                parameters.append("per_page", 100.toString())
            }
        }.body()
    }
}
