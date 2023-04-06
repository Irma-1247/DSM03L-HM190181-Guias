package sv.edu.udb.guia08app.datos

class Persona {
    fun key(key: String?) {
    }
    var nombre: String? = null
    var dui: String? = null
    var fecha: String? = null
    var genero: String? = null
    var peso: String? = null
    var altura: String? = null
    var key: String? = null
    var per: MutableMap<String, Boolean> = HashMap()
    constructor() {}
    constructor(dui: String?, nombre: String?, fecha: String?, genero: String?, peso: String?, altura: String?) {
        this.nombre = nombre
        this.dui = dui
        this.fecha = fecha
        this.genero = genero
        this.peso = peso
        this.altura = altura
    }
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "nombre" to nombre,
            "dui" to dui,
            "fecha" to fecha,
            "genero" to genero,
            "peso" to peso,
            "altura" to altura,
            "key" to key,
            "per" to per
        )
    }
}