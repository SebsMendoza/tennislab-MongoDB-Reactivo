package models

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import utils.CalculoPrecioTarea
import java.util.*

@Serializable
class Adquisicion(
    @BsonId @Contextual
    val id: Id<Adquisicion> = newId(),
    @Contextual
    val uuid: UUID = UUID.randomUUID(),
    var cantidad: Int,
    val producto: Producto,
    val precio: Double = CalculoPrecioTarea.calculatePrecio(producto.precio, null, null) * cantidad

) {
    override fun toString(): String {
        return ObjectMapper().writeValueAsString(this)
    }
}