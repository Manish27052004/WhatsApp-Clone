package com.example.whatsappclone.presentation.viewmodels

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.database

import com.google.firebase.storage.storage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    private val _profileState = MutableStateFlow<ProfileState>(ProfileState.Idle)
    val profileState = _profileState.asStateFlow()

    private val auth = Firebase.auth
    private val database = Firebase.database.reference
    private val storage = Firebase.storage.reference

    sealed class ProfileState {
        object Idle : ProfileState()
        object Saving : ProfileState()
        object ProfileSaved : ProfileState()
        data class Error(val message: String) : ProfileState()
    }

    data class UserProfile(
        val userId: String = "",
        val name: String = "",
        val phoneNumber: String = "",
        val status: String = "",
        val profilePictureUrl: String = ""
    )

    fun saveProfile(name: String, status: String, imageUri: Uri?) {
        viewModelScope.launch {
            _profileState.value = ProfileState.Saving
            try {
                val userId = auth.currentUser?.uid
                if (userId == null) {
                    _profileState.value = ProfileState.Error("User not logged in.")
                    return@launch
                }

                var profilePictureUrl = ""
                if (imageUri != null) {
                    val profilePicRef = storage.child("profile_pictures/$userId.jpg")
                    profilePicRef.putFile(imageUri).await()
                    profilePictureUrl = profilePicRef.downloadUrl.await().toString()
                }

                val userProfile = UserProfile(
                    userId = userId,
                    name = name,
                    phoneNumber = auth.currentUser?.phoneNumber ?: "",
                    status = status,
                    profilePictureUrl = profilePictureUrl
                )

                database.child("users").child(userId).setValue(userProfile).await()
                _profileState.value = ProfileState.ProfileSaved
            } catch (e: Exception) {
                _profileState.value = ProfileState.Error(e.message ?: "An error occurred.")
            }
        }
    }
}
