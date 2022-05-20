package com.ehanlin.model

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class UniformInvoice(val rewardType:String, val code:List<String>)

@Serializable
data class Lottery(val year:Int, val fromMonth:Int, val toMonth:Int, val list:List<UniformInvoice>)

fun Route.listUniformInvoiceRoute() {
    route("/uniform-invoice") {
        get("/list") {
            val uniformInvoiceList = listOf(
                UniformInvoice(rewardType = "特別獎", code = listOf("18927486")),
                UniformInvoice(rewardType = "特獎", code = listOf("82050976")),
                UniformInvoice(rewardType = "頭獎", code = listOf("46596321", "75704516", "48632657")),
            )
            val lottery = Lottery(year = 111, fromMonth = 1, toMonth = 2, list = uniformInvoiceList)
            call.respond(lottery)
        }
    }
}
