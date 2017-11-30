package JapanMicroSystem.EqmsMobileServer.Entity

import java.util.*

data class TBL_EQUIPMENT(
        val EQUIP_CODE:String,
        val EQUIP_KBN:String?,
        val EQUIP_NAME:String?,
        val REMARK:String?,
        val ABOLISH_FLG:String?,
        val SET_WORKER:String?,
        val SET_DATE:String?,
        val INVENTORY_DATE:String?,
        val EQUIP_CLASS:String?,
        val INVENTORY_KBN:String?,
//        val EQUIP_IMAGE:Byte,
        val ABOLISH_WORKER:String?,
        val ABOLISH_DATE:String?,
        val ABOLISH_REASON:String?,
        val ABOLISH_REMARK:String?
)