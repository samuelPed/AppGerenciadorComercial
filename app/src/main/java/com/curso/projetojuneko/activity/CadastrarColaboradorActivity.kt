package com.curso.projetojuneko.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.curso.projetojuneko.databinding.ActivityCadastrarColaboradorBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastrarColaboradorActivity : AppCompatActivity() {
    private lateinit var usuarios: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityCadastrarColaboradorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarColaboradorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Ocultar ToolBar
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        usuarios = FirebaseDatabase.getInstance().getReference("usuarios")

        //CheckBok Visivel para nível de privilégio do colaborador
        binding.swCadastro.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {//Colaborador
                binding.rgPrevilegio.visibility = View.VISIBLE

            } else {//Cozinha
                binding.rgPrevilegio.visibility = View.GONE

            }
        }
        binding.btnNovoColaborador.setOnClickListener {
            cadastrarUsuario()
        }

    }

    private fun cadastrarUsuario() {
        val email = binding.editEmailColaborador.text.toString()
        val senha = binding.editSenhaColaborador.text.toString()
        val nome = binding.editNomeColaborador.text.toString()
        var status: String
        if (!email.isEmpty()) {
            if (!senha.isEmpty()) {
                if (!nome.isEmpty()) {
                    //Verificar switch
                    if (binding.swCadastro.isChecked) {//Colaborador
                        binding.rgPrevilegio.visibility = View.VISIBLE

                        if (binding.rbN1.isChecked) {
                            auth = FirebaseAuth.getInstance()
                            auth.createUserWithEmailAndPassword(email, senha)
                                .addOnCompleteListener(this) {
                                    if (it.isSuccessful) {
                                        Toast.makeText(
                                            this,
                                            "Sucesso ao cadastrar o usuário!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        Log.i("CreateUser", "Sucesso ao cadastrar usuário")
                                        status = "Atendente"
                                        usuarioPrivilegio(nome, email, status)
                                        finish()
                                    } else {
                                        Toast.makeText(
                                            this,
                                            "Erro ao cadastrar o usuário!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        Log.i("CreateUser", "Erro ao cadastrar usuário")
                                    }
                                }
                        } else if (binding.rbN2.isChecked) {
                            auth = FirebaseAuth.getInstance()
                            auth.createUserWithEmailAndPassword(email, senha)
                                .addOnCompleteListener(this) {
                                    if (it.isSuccessful) {
                                        Toast.makeText(
                                            this,
                                            "Sucesso ao cadastrar o usuário!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        Log.i("CreateUser", "Sucesso ao cadastrar usuário")
                                        status = "Gerente"
                                        usuarioPrivilegio(nome, email, status)
                                        finish()
                                    } else {
                                        Toast.makeText(
                                            this,
                                            "Erro ao cadastrar o usuário!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        Log.i("CreateUser", "Erro ao cadastrar usuário")
                                    }
                                }
                        } else if (binding.rbN3.isChecked) {
                            auth = FirebaseAuth.getInstance()
                            auth.createUserWithEmailAndPassword(email, senha)
                                .addOnCompleteListener(this) {
                                    if (it.isSuccessful) {
                                        Toast.makeText(
                                            this,
                                            "Sucesso ao cadastrar o usuário!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        Log.i("CreateUser", "Sucesso ao cadastrar usuário")
                                        status = "Administrador"
                                        usuarioPrivilegio(nome, email, status)
                                        finish()
                                    } else {
                                        Toast.makeText(
                                            this,
                                            "Erro ao cadastrar o usuário!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        Log.i("CreateUser", "Erro ao cadastrar usuário")
                                    }
                                }
                        } else {//Selecionar o nível do colaborador
                            Toast.makeText(
                                this, "Selecione o nível de previlégio do colaborador.",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            Log.i("CreateUser", "Selecione o nível de previlégio do colaborador")

                        }
                    } else {//Cozinha

                        binding.rgPrevilegio.visibility = View.GONE
                        auth = FirebaseAuth.getInstance()
                        auth.createUserWithEmailAndPassword(email, senha)
                            .addOnCompleteListener(this) {
                                if (it.isSuccessful) {
                                    Toast.makeText(
                                        this,
                                        "Sucesso ao cadastrar usuário cozinha!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    Log.i(
                                        "CreateUser",
                                        "Sucesso ao cadastrar usuário cozinha"
                                    )
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this,
                                        "Erro ao cadastrar usuário cozinha!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    Log.i("CreateUser", "Erro ao cadastrar usuário cozinha")
                                }
                            }
                    }
                } else {
                    Toast.makeText(
                        this, "Preencha o e-mail!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this, "Preencha a senha!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                this, "Preencha o nome!",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

    data class User(val nome: String? = null, val email: String? = null, val status: String? = null)

    //Salvar os dados dos usuários no Firebase DataBaseReal Time
    private fun usuarioPrivilegio(nome: String, email: String, status: String) {
        val user = User(nome, email, status)

        if (binding.rbN1.isChecked) {
            usuarios.child("atendentes").push().child("userId").setValue(user)
        } else if (binding.rbN2.isChecked) {
            usuarios.child("gerentes").push().child("userId").setValue(user)
        } else if (binding.rbN3.isChecked) {
            usuarios.child("administradores").push().child("userId").setValue(user)
        }
    }
}
