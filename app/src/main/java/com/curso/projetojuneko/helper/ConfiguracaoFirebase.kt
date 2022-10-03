package com.curso.projetojuneko.helper

import com.google.firebase.database.DatabaseReference
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.StorageReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

object ConfiguracaoFirebase {
    private var referenciaFirebase: DatabaseReference? = null
    private var referenciaAutenticacao: FirebaseAuth? = null
    private var referenciaStorage: StorageReference? = null

    //retornar referencia do database
    val firebase: DatabaseReference?
        get() {
            if (referenciaFirebase == null) {
                referenciaFirebase = FirebaseDatabase.getInstance().reference
            }
            return referenciaFirebase
        }

    //retornar a instancia firebaseAuth
    val firebaseAutencicacao: FirebaseAuth?
        get() {
            if (referenciaAutenticacao == null) {
                referenciaAutenticacao = FirebaseAuth.getInstance()
            }
            return referenciaAutenticacao
        }

    //retornar a instancia do FirebaseStorage
    val firebaseStorage: StorageReference?
        get() {
            if (referenciaStorage == null) {
                referenciaStorage = FirebaseStorage.getInstance().reference
            }
            return referenciaStorage
        }
    val idUsuario: String
        get() {
            val auth = firebaseAutencicacao
            return auth!!.currentUser!!.uid
        }
}