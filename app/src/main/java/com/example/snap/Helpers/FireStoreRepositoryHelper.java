package com.example.snap.Helpers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.snap.DataModel.CheckListAnswerModel;
import com.example.snap.DataModel.SnapUser;
import com.example.snap.Interfaces.OnChecklistSubmittion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.Date;

public class FireStoreRepositoryHelper {


    public static void enableFireStoreOfflinePersistence() {
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED)
                .setPersistenceEnabled(true)
                .build();
        FirebaseFirestore.getInstance().setFirestoreSettings(settings);


    }

    public static void saveUserInfoToFireStore(SnapUser user) {
        FirebaseFirestore.getInstance().collection("Users")
                .document(FirebaseAuthHelper.getCurrentUser().getUid())
                .collection("profile").add(user).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.getException() != null) {
                    System.out.println(task.getException().getMessage());
                } else {
                    System.out.println("Snap User have been sent to firestore");
                }
            }
        });

    }

    public static void saveHeathChecklistToFireStore(CheckListAnswerModel checkList, OnChecklistSubmittion cb) {
        FirebaseFirestore.getInstance().collection("Users").document(FirebaseAuthHelper.getCurrentUser().getUid())
                .collection("healthCheckList")
                .document(String.valueOf(new Date())).set(checkList).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.getException() != null){
                    System.out.println(task.getException().getMessage());
                }else{
                    System.out.println("CheckList answers saved to firestore");
                    cb.onSubmit();
                }
            }
        });




    }


}
