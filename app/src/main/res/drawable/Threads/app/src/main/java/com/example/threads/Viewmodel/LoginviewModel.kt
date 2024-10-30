package com.example.threads.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class LoginviewModel:ViewModel() {

    val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance()
    val userref = db.getReference("users")

    private val _firebaseuser = MutableLiveData<FirebaseUser>()
    val firebaseUser : LiveData<FirebaseUser> = _firebaseuser

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error

    init {

        _firebaseuser.value = auth.currentUser

    }


    fun login(email : String , password : String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if (it.isSuccessful) {
                    _firebaseuser.postValue(auth.currentUser)
                } else {
                    _error.postValue("something went wrong")
                }
                }
            }

    fun Register(email : String , password : String , name:String ,bio:String , userName :String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if (it.isSuccessful) {
                    _firebaseuser.postValue(auth.currentUser)
                } else {
                    _error.postValue("something went wrong")
                }
            }
    }


}