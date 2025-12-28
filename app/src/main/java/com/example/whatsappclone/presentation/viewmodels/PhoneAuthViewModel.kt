package com.example.whatsappclone.presentation.viewmodels

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.util.Base64
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.whatsappclone.models.PhoneAuthUser
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.ByteArrayOutputStream



@HiltViewModel
class PhoneAuthViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val database: FirebaseDatabase
) : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Ideal)
    val authState = _authState.asStateFlow()

    private val userRef = database.reference.child("users")
    fun sendVerificationCode(phoneNumber: String, activity: Activity) {
        _authState.value = AuthState.Loading
        val option = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(id, token)
                Log.d("PhoneAuth", "onCodeSent triggered. verification ID: $id")
                _authState.value = AuthState.CodeSent(verificationId = id)
            }

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.d("PhoneAuth", "onVerificationCompleted triggered")
                signInWithCredential(credential, context = activity)
            }

            override fun onVerificationFailed(exception: FirebaseException) {
                Log.d("PhoneAuth", "onVerificationFailed: ${exception.message}")
                _authState.value = AuthState.Error(exception.message ?: "Verification Failed")
            }

        }


        val phoneAuthOptions = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, java.util.concurrent.TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(option)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(phoneAuthOptions)
    }

    fun verifyCode(otp:String, context: Activity){
        val currentAuthState = _authState.value
        if(currentAuthState !is AuthState.CodeSent || currentAuthState.verificationId.isEmpty()){
            Log.e("PhoneAuth", "Attempting to verify otp without a valid verification ID")
            _authState.value = AuthState.Error("Invalid verification ID")
            return

        }
        val credential = PhoneAuthProvider.getCredential(currentAuthState.verificationId, otp)
        signInWithCredential(credential, context)
    }
    fun saveUserProfile(userId: String, name: String, status: String, profileImage: Bitmap?){
        val database = FirebaseDatabase.getInstance().reference
        val encodedImage = profileImage?.let{convertBitmapToBase64(it)}
        val userProfile = PhoneAuthUser(
            userId = userId,
            phoneNumber = Firebase.auth.currentUser?.phoneNumber?: "",
            Name = name,
            status = status,
            profileImage = encodedImage,
        )
        database.child("users").child(userId).setValue(userProfile)


    }
    private fun convertBitmapToBase64(bitmap: Bitmap): String? {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }
    fun resetAuthState(){
        _authState.value = AuthState.Ideal
    }
    fun signOut(activity: Activity){
     firebaseAuth.signOut()
     val sharedPreference = activity.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        sharedPreference.edit().putBoolean("is_signed_in", false).apply()
        _authState.value = AuthState.Ideal
    }

    private fun signInWithCredential(
        credential: PhoneAuthCredential,
        context: Activity
    ) {
        _authState.value = AuthState.Loading
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    val phoneAuthUser = PhoneAuthUser(
                        userId = user?.uid ?: "",
                        phoneNumber = user?.phoneNumber ?: "",
                    )

                    markUserAsSignedIn(context)
                    _authState.value = AuthState.Success(phoneAuthUser)
                    fetchUserProfile(user?.uid ?: "")


                } else {
                    _authState.value =
                        AuthState.Error(it.exception?.message ?: "Verification Failed")

                }
            }
    }
    private fun markUserAsSignedIn(context: Context){
        val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("is_signed_in", true).apply()


    }
    private fun fetchUserProfile(userId: String){
        val userRef = database.reference.child("users").child(userId)
        userRef.get().addOnSuccessListener {snapshot->
            if (snapshot.exists()){
                val userProfile = snapshot.getValue(PhoneAuthUser::class.java)
                if (userProfile != null){
                    _authState.value = AuthState.Success(userProfile)
                }else{
                    _authState.value = AuthState.Error("User profile not found")
                }


            }
        }.addOnFailureListener {
            _authState.value= AuthState.Error("Failed to fetch user profile")
        }
    }


}



sealed class AuthState {
    object Ideal : AuthState()
    object Loading : AuthState()
    data class CodeSent(val verificationId: String) : AuthState()
    data class Success(val user: PhoneAuthUser) : AuthState()
    data class Error(val message: String) : AuthState()
}
