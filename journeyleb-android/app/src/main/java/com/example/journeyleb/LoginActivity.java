package com.example.journeyleb;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextemail, editTextPassword;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DatabaseHelper(this);

        editTextemail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);


    }

    public void onLoginClick(View view) {
        String email =  editTextemail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            // Handle empty username or password
            Toast.makeText(this, "email and password are required", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if the user exists in the database
        new LoginAsyncTask().execute(email, password);
    }

    private class LoginAsyncTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            String email = params[0];
            String password = params[1];

            try {
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                String[] projection = {"client_email", "client_password"};
                String selection = "client_email = ? AND client_password = ?";
                String[] selectionArgs = {email, password};

                // Query the database to check if the user exists
                Cursor cursor = db.query("Client", projection, selection, selectionArgs, null, null, null);

                boolean userExists = cursor.getCount() > 0;

                // Close the cursor and database connection
                cursor.close();
                db.close();

                return userExists;
            } catch (Exception e) {
                // Log the error for debugging
                return false;
            }
        }
        protected void onPostExecute(Boolean userExists) {
            if (userExists) {
                // User exists, allow login
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                // Redirect to the main application screen
                Intent intent = new Intent(LoginActivity.this,DisplayCity.class);
                startActivity(intent);
                finish(); // Close the current activity to prevent the user from coming back
            } else {
                // User doesn't exist, show AlertDialog with option to register
                showRegisterDialog();
            }
        }
    }

    private void showRegisterDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("User not registered. Do you want to register now?")
                .setPositiveButton("Register", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Redirect to the registration page
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Close the current activity to prevent the user from coming back
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Close the dialog
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}