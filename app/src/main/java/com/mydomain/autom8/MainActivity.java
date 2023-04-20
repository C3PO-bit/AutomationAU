package com.mydomain.autom8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.mydomain.autom8.databinding.ActivityMainBinding;
import com.mydomain.autom8.screen.HomeActivity;
import com.mydomain.autom8.screen.SignupActivity;

import java.security.acl.Group;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        statusBarTextColor();
        redirectToDashboard();
        redirectToSignup();

    }

    //change text color in status bar
    private void statusBarTextColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    //open home dashboard after login success
    private void redirectToDashboard() {
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               validateAllFields();
            }
        });

    }

    //login validation methods
    private boolean validateEmail() {
        String email = binding.email.getEditText().getText().toString();
        String testEmail = "test@autom8au.com.au";
        if (email.isEmpty()) {
            binding.email.setError("This field is required");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.email.setError("Enter valid email address");
            return false;
        } else if (!email.matches(testEmail)) {
            binding.email.setError("Email is incorrect");
            return false;
        } else {
            binding.email.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String password = binding.password.getEditText().getText().toString();
        String testPassword = "12345";
        if (password.isEmpty()) {
            binding.password.setError("This field is required");
            return false;
        } else if (!password.matches(testPassword)) {
            binding.password.setError("Password is incorrect");
            return false;
        } else {
            binding.password.setError(null);
            return true;
        }
    }

    private void validateAllFields() {
        if (validateEmail()  && validatePassword()) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    //redirect to signup screen
    private void redirectToSignup() {
        binding.createAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }


}