package com.mydomain.autom8.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mydomain.autom8.MainActivity;
import com.mydomain.autom8.R;
import com.mydomain.autom8.databinding.ActivitySignupBinding;

import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       redirectToLoginScreen();
       redirectToLoginOnCLick();
    }

    //Redirect to login screen after registration is successful
    private void redirectToLoginScreen() {
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAllFields();
            }
        });
    }

    //validate registration methods
    //validate name
    private boolean validateName() {
        String name = binding.name.getEditText().getText().toString();

        if (!name.isEmpty()) {
            binding.name.setError(null);
            return true;
        } else {
            binding.name.setError("This field is required");
            return false;
        }

    }

    //validate email
    private boolean validateEmail() {
        String email = binding.email.getEditText().getText().toString();
        if (email.isEmpty()) {
            binding.email.setError("This field is required");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.email.setError("Enter valid email address");
            return false;
        } else {
            binding.email.setError(null);
            return true;
        }
    }

    //validate password
    private boolean validatePassword() {
        String password = binding.password.getEditText().getText().toString();
        if (password.length() >= 6) {
            binding.password.setError(null);
            return true;
        } else {
            binding.password.setError("Password must contains at least 6 characters");
            return false;
        }
    }

    //validate repeat password
    private boolean validateRepeatPassword() {
        String repeatPassword = binding.repeatPassword.getEditText().getText().toString();
        String password = binding.password.getEditText().getText().toString();
        if (repeatPassword.contains(password)) {
            binding.repeatPassword.setError(null);
            return true;
        } else {
            binding.repeatPassword.setError("Password is not match");
            return false;
        }
    }
    //validate all fields
    private void validateAllFields() {
        if (validateName() && validateEmail() && validatePassword() && validateRepeatPassword() && acceptTerms()) {
            showToast();
            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_SHORT).show();
        }
    }

    //validate checkbox
    private boolean acceptTerms() {

        if (!binding.terms.isChecked()) {
            binding.privatePolicy.setTextColor(Color.parseColor("#cc0000"));
            return false;
        } else {
            binding.terms.setError(null);
            return true;
        }
    }
    //Custom toast message for successful signup
    private void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.register_success,(ViewGroup) findViewById(R.id.success));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();
    }

    //redirect to login screen when login text is clicked
    private void redirectToLoginOnCLick() {
        binding.loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}