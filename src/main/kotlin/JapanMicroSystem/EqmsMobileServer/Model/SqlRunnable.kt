package JapanMicroSystem.EqmsMobileServer.Model

import JapanMicroSystem.EqmsMobileServer.Entity.TBL_EQUIPMENT

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class SqlRunnable {
    companion object {
        @JvmStatic private val USER ="sa"
        @JvmStatic private val PASSWORD = "azuraflame00"
        @JvmStatic private val DB = "jdbc:sqlserver://192.168.1.208:64591;"+"instanceName=EQMSMOBILE;"+"userName="+ USER + ";password="+ PASSWORD + ";"
    }

    private var connection:Connection? = null
    private var statement:Statement? = null
    private var resultSet:ResultSet? = null

//    var listBuilder = ArrayList<TBL_EQUIPMENT>()
    fun findAllEntity():List<TBL_EQUIPMENT>{
        val listBuilder = ArrayList<TBL_EQUIPMENT>()

        try {
            connection = DriverManager.getConnection(DB)
            statement = connection?.createStatement()
            resultSet = statement?.executeQuery("select * from TBL_EQUIPMENT")
            while (resultSet?.next() ?: false) {
                listBuilder.add(TBL_EQUIPMENT(
                        EQUIP_CODE = resultSet?.getString("EQUIP_CODE") ?: throw ClassCastException(),
                        EQUIP_KBN = resultSet?.getString("EQUIP_KBN"),
                        EQUIP_NAME = resultSet?.getString("EQUIP_NAME"),
                        REMARK = resultSet?.getString("REMARK"),
                        ABOLISH_FLG = resultSet?.getString("ABOLISH_FLG"),
                        SET_WORKER = resultSet?.getString("SET_WORKER"),
                        SET_DATE = resultSet?.getString("SET_DATE"),
                        INVENTORY_DATE = resultSet?.getString("INVENTORY_DATE"),
                        EQUIP_CLASS = resultSet?.getString("EQUIP_CLASS"),
                        INVENTORY_KBN = resultSet?.getString("INVENTORY_KBN"),
                        ABOLISH_WORKER = resultSet?.getString("ABOLISH_WORKER"),
                        ABOLISH_DATE = resultSet?.getString("ABOLISH_DATE"),
                        ABOLISH_REASON = resultSet?.getString("ABOLISH_REASON"),
                        ABOLISH_REMARK = resultSet?.getString("ABOLISH_REMARK"))
                )
            }
            return listBuilder
        }catch (e:Exception){
            println(e)
            throw ClassCastException()
        }finally {
            connection?.close()
            statement?.close()
            resultSet?.close()
        }

    }
}