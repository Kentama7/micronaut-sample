package micronaut.sample.app

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.NotNull

@Validated
@Controller("/validation")
class ValidationController {

    @Post("/")
    fun index(@Body @Valid form: ValidationForm): HttpStatus {
        return HttpStatus.OK
    }
}

data class ValidationForm(
        @field:NotNull
        val name: String,

        @field:Max(10)
        val age: Int
)