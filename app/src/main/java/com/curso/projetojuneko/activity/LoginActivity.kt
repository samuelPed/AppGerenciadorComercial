package com.curso.projetojuneko.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.curso.projetojuneko.R
import com.curso.projetojuneko.databinding.ActivityLoginBinding
import com.curso.projetojuneko.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Referenciando a classe ViewModel, usando método lambda.
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        //Eventos
        binding.btnLogin.setOnClickListener(this)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        updateUI(currentUser)

    }

    public override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btnLogin) {
            verificarAutenticacao()
        } else {
            Toast.makeText(this, "Erro ao autenticar usuário", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            verificarAutenticacao()
        }

    }

    fun telaRecuperaSenha(view: View) {
        val intent = Intent(this, EsqueceuSenhaActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private const val TAG = "AutenticarUsuário"
    }

    private fun verificarAutenticacao() {
        val email = binding.editLoginEmail.text.toString()
        val senha = binding.editLoginSenha.text.toString()

        if (!email.isEmpty()) {
            if (!senha.isEmpty()) {
                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this) {

                    //Verifica estado do switch
                    if (binding.swLogar.isChecked) {//Colaborador
                        if (it.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCustomToken:success")
                            val user = auth.currentUser
                            updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCustomToken:failure", it.exception)
                            Toast.makeText(
                                baseContext, "Erro! Verifique a senha!",
                                Toast.LENGTH_SHORT
                            ).show()
                            updateUI(null)
                        }
                    } else {//Cozinha

                    }
                }
            } else {
                Toast.makeText(
                    this, "Preencha a senha!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                this, "Preencha o e-mail!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
