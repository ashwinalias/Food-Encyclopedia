package com.example.pc.food_encyclopedia;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.food_encyclopedia.constants.Constants;
import com.example.pc.food_encyclopedia.util.FEUtils;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.graphics.Color.WHITE;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private LoginButton loginButton;
    private CallbackManager mFbCallbackManager;
    private GoogleSignInClient mGoogleSignInClient;
    private Button mLoginWithMobile;
    private Button mLogin;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        initScreens();
        if (checkAndRequestPermissions()) {
            // carry on the normal flow, as the case of  permissions  granted.
            loginWithMobile();
        }
    }
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("otp")) {
                final String message = intent.getStringExtra("message");

             //   TextView tv = (TextView) findViewById(R.id.txtview);
               // tv.setText(message);
            }
        }
    };

    private void initScreens() {
        //setting font style
        getSupportActionBar().hide();
        TextView textView = findViewById(R.id.welcome_foodes);
        Typeface type = Typeface.createFromAsset(getAssets(), "ZapChance.ttf");
        textView.setTypeface(type);

        //setting up Fb Login
        loginButton = (LoginButton) findViewById(R.id.login_button_fb);
        loginButton.setPadding(getResources().getDimensionPixelSize(R.dimen.login_activity_fb_login__btn_padding),
                getResources().getDimensionPixelSize(R.dimen.login_activity_fb_login__btn_padding),
                getResources().getDimensionPixelSize(R.dimen.login_activity_fb_login__btn_padding),
                getResources().getDimensionPixelSize(R.dimen.login_activity_fb_login__btn_padding));
        loginButton.setReadPermissions(Arrays.asList("email"));
        mFbCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mFbCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Toast.makeText(LoginActivity.this, "Fb login success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(LoginActivity.this, "Fb login  cancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(LoginActivity.this, "Fb login  Failed", Toast.LENGTH_SHORT).show();
                    }
                });


        //Setting up Google Login
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        SignInButton signInButton = findViewById(R.id.sign_in_button_glge);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setPadding(getResources().getDimensionPixelSize(R.dimen.login_activity_fb_login__btn_padding),
                getResources().getDimensionPixelSize(R.dimen.login_activity_g_login__btn_top_padding),
                getResources().getDimensionPixelSize(R.dimen.login_activity_g_login__btn_padding),
                getResources().getDimensionPixelSize(R.dimen.login_activity_g_login__btn_top_padding));
        setGooglePlusButtonText(signInButton,"Continue with google");
        signInButton.setOnClickListener(this);

        //Login with mobile
        mLoginWithMobile = (Button) findViewById(R.id.btn_login_mobile);
        mLoginWithMobile.setPadding(getResources().getDimensionPixelSize(R.dimen.login_activity_fb_login__btn_padding),
                getResources().getDimensionPixelSize(R.dimen.login_activity_g_login__btn_top_padding),
                getResources().getDimensionPixelSize(R.dimen.login_activity_fb_gle__btn_top_padding),
                getResources().getDimensionPixelSize(R.dimen.login_activity_g_login__btn_padding));
        mLoginWithMobile.setOnClickListener(this);
        mLogin = (Button) findViewById(R.id.btn_login);
        mLogin.setOnClickListener(this);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 25) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
        mFbCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button_glge:
                signInGoogle();
                break;
            case R.id.btn_login_mobile:
                loginWithMobile();
                break;
            case R.id.btn_login:
                Intent intent  = new Intent(LoginActivity.this,MainActivity.class);
                LoginActivity.this.startActivity(intent);
                break;
        }
    }


   //Method used to sign in into google
    private void signInGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 25);
    }
//Method used to login with mobile numer
    private void loginWithMobile(){
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
        View mView = layoutInflaterAndroid.inflate(R.layout.custom_dialog, null);
        TextView mTitle = (TextView) mView.findViewById(R.id.dialogTitle);
        EditText mUSerInput = (EditText) mView.findViewById(R.id.userInputDialog) ;
        mUSerInput.setBackgroundResource(R.drawable.edittext_border);
        mTitle.setText(Constants.ENTER_PHONE_NUMBER);
        mTitle.setTextSize(20);
        mTitle.setTextColor(WHITE);
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(this);
        alertDialogBuilderUserInput.setView(mView);

        final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        // ToDo get user input here
                    }
                })

                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

        AlertDialog dialog = alertDialogBuilderUserInput.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(WHITE));

        dialog.show();
    }

   //This method recives google sign in info (if success)
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Toast.makeText(this, "Google sign in success " + account.getEmail(), Toast.LENGTH_SHORT).show();
        } catch (ApiException e) {
            Toast.makeText(this, "Google sign in falure ", Toast.LENGTH_SHORT).show();
        }
    }

    protected void setGooglePlusButtonText(SignInButton signInButton, String buttonText) {
        // Find the TextView that is inside of the SignInButton and set its text
        for (int i = 0; i < signInButton.getChildCount(); i++) {
            View v = signInButton.getChildAt(i);

            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                tv.setText(buttonText);
                return;
            }
        }
    }

    private  boolean checkAndRequestPermissions() {
        int permissionSendMessage = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);
        int receiveSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        int readSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (receiveSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.RECEIVE_MMS);
        }
        if (readSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_SMS);
        }
        if (permissionSendMessage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.SEND_SMS);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS
                    );
            return false;
        }
        return true;
    }

    @Override
    protected void onResume() {
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("otp"));
        super.onResume();
    }
}
