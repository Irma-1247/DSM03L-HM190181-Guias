package sv.edu.udb.guia08app

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import sv.edu.udb.guia08app.datos.Persona

class AddPersonaActivity : AppCompatActivity() {
    private var edtNombre: EditText? = null
    private var edtDUI: EditText? = null
    private var edtAltura: EditText? = null
    private var edtGenero: EditText? = null
    private var edtPeso: EditText? = null
    private var edtFecha: EditText? = null
    private var key = ""
    private var accion = ""
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_persona)
        inicializar()
    }

    private fun inicializar() {
        edtNombre = findViewById<EditText>(R.id.edtNombre)
        edtDUI = findViewById<EditText>(R.id.edtDUI)
        edtFecha = findViewById<EditText>(R.id.edtFecha)
        edtGenero = findViewById<EditText>(R.id.edtGenero)
        edtAltura= findViewById<EditText>(R.id.edtAltura)
        edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtNombre = findViewById<EditText>(R.id.edtNombre)
        val edtDUI = findViewById<EditText>(R.id.edtDUI)
        val edtFecha = findViewById<EditText>(R.id.edtFecha)
        val edtGenero = findViewById<EditText>(R.id.edtGenero)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)
        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        // Obtención de datos que envia actividad anterior
        val datos: Bundle? = intent.getExtras()
        if (datos != null) {
            key = datos.getString("key").toString()
        }
        if (datos != null) {
            edtDUI.setText(intent.getStringExtra("dui").toString())
        }
        if (datos != null) {
            edtNombre.setText(intent.getStringExtra("nombre").toString())
        }
        if (datos != null) {
            edtAltura.setText(intent.getStringExtra("altura").toString())
        }
        if (datos != null) {
            edtFecha.setText(intent.getStringExtra("fecha").toString())
        }
        if (datos != null) {
            edtGenero.setText(intent.getStringExtra("genero").toString())
        }
        if (datos != null) {
            edtPeso.setText(intent.getStringExtra("peso").toString())
        }
        if (datos != null) {
            accion = datos.getString("accion").toString()
        }
    }

    fun guardar(v: View?) {
        val nombre: String = edtNombre?.text.toString()
        val dui: String = edtDUI?.text.toString()
        val altura: String = edtAltura?.text.toString()
        val peso: String = edtPeso?.text.toString()
        val genero: String = edtGenero?.text.toString()
        val fecha: String = edtFecha?.text.toString()
        database = FirebaseDatabase.getInstance().getReference("personas")
        // Se forma objeto persona
        val persona = Persona(dui, nombre, altura, peso, genero, fecha)
        if (accion == "a") { //Agregar registro
            database.child(nombre).setValue(persona).addOnSuccessListener {
                Toast.makeText(this, "Se guardo con exito", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed ", Toast.LENGTH_SHORT).show()
            }
        } else // Editar registro
        {
            val key = database.child("nombre").push().key
            if (key == null) {
                Toast.makeText(this, "Llave vacia", Toast.LENGTH_SHORT).show()
            }
            val personasValues = persona.toMap()
            val childUpdates = hashMapOf<String, Any>(
                "$nombre" to personasValues
            )
            database.updateChildren(childUpdates)
            Toast.makeText(this, "Se actualizo con exito", Toast.LENGTH_SHORT).show()
        }
        finish()
    }

    fun cancelar(v: View?) {
        finish()
    }
}