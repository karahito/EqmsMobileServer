package JapanMicroSystem.EqmsMobileServer.Controller

import JapanMicroSystem.EqmsMobileServer.Entity.TBL_EQUIPMENT
import JapanMicroSystem.EqmsMobileServer.Model.SqlRunnable
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
class EqmsController {
    @RequestMapping("/findAll")
    @ResponseBody
    fun findAll():List<TBL_EQUIPMENT> {
        return SqlRunnable().findAllEntity()
    }
}