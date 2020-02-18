package info.androidhive.paytmgateway.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.androidhive.paytmgateway.R;
import info.androidhive.paytmgateway.db.AppDatabase;
import info.androidhive.paytmgateway.db.AppPref;
import info.androidhive.paytmgateway.db.model.User;
import info.androidhive.paytmgateway.networking.model.LoginRequest;
import info.androidhive.paytmgateway.ui.base.BaseActivity;
import info.androidhive.paytmgateway.ui.register.RegisterActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.input_email)
    EditText inputEmail;

    @BindView(R.id.input_password)
    EditText inputPassword;

    @BindView(R.id.loader)
    AVLoadingIndicatorView loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeFullScreen();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        changeStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        hideToolbar();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.btn_login)
    void onLoginClick() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), getString(R.string.msg_enter_credentials), Toast.LENGTH_LONG).show();
            return;
        }

        loader.setVisibility(View.VISIBLE);
        LoginRequest request = new LoginRequest();
        request.email = email;
        request.password = password;
        getApi().login(request).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                loader.setVisibility(View.INVISIBLE);
                if (!response.isSuccessful()) {
                    handleError(response.errorBody());
                    return;
                }

                AppDatabase.saveUser(response.body());
                AppPref.getInstance().saveAuthToken(response.body().token);
                launchSplash(LoginActivity.this);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loader.setVisibility(View.INVISIBLE);
                handleError(t);
            }
        });
    }

    @OnClick(R.id.btn_create_account)
    void onCreateAccountClick() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
