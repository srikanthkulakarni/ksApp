package com.example.adminapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginScAdmFrag extends Fragment {

    EditText emailTvLoginScAdm,passTvLoginScAdm;
    Button loginBtnLogicScAdm;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String email,pass;

    public LoginScAdmFrag() {
        // Required empty public constructor
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_sc_adm,container,false);
        loginBtnLogicScAdm = view.findViewById(R.id.loginBtnLogicScAdm);
        emailTvLoginScAdm = view.findViewById(R.id.emailTvLoginScAdm);
        passTvLoginScAdm = view.findViewById(R.id.passTvLoginScAdm);
        loginBtnLogicScAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gAuth();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            startActivity(new Intent(getActivity(),HomeScAdm.class));
        }else{
            gAuth();
        }
    }

    private void gAuth() {
        if(emailTvLoginScAdm.getText()!=null && passTvLoginScAdm.getText()!=null){
            email = emailTvLoginScAdm.getText().toString().trim();
            pass = passTvLoginScAdm.getText().toString().trim();
            if(!email.matches("") && !pass.matches("")){
                mAuth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getActivity(), "Login Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getActivity(),HomeScAdm.class));
                                }else{
                                    Toast.makeText(getActivity(), "Login Failure", Toast.LENGTH_SHORT).show();
                                    Log.i("Else part",task.getException().getMessage());
                                    Log.i("Else part",pass);
                                }
                            }
                        });
            }else{
                Drawable customErrorDrawable = getResources().getDrawable(R.drawable.ic_baseline_error_24);
                customErrorDrawable.setBounds(0,0,customErrorDrawable.getIntrinsicWidth(),
                            customErrorDrawable.getIntrinsicHeight());
                emailTvLoginScAdm.setError("Field cannot be empty");
                passTvLoginScAdm.setError("Field cannot be empty");
            }
        }else{
            Toast.makeText(getActivity(), "Field cannot be left empty", Toast.LENGTH_SHORT).show();
        }
    }//End googleAuth
}