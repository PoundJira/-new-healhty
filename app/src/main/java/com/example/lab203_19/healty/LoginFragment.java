package com.example.lab203_19.healty;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by LAB203_19 on 20/8/2561.
 */

public class LoginFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void onActivityCreated(
            @Nullable Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);

        initLoginBtn();
        initRegiserBtn();

    }
    void initLoginBtn(){
        Button _loginBtn = (Button) getView().findViewById(R.id.login_login_btn);
        _loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText _userId = (EditText) getView().findViewById(R.id.login_user_id);
                EditText _password = (EditText) getView().findViewById(R.id.login_password);

                String _userIdStr = _userId.getText().toString();
                String _passwordStr = _password.getText().toString();
                if(_userIdStr.isEmpty() || _passwordStr.isEmpty()){
                    Toast.makeText(
                            getActivity(),
                            "please fill user and password",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("USER","USER OR PASSWORD IS EMPTY");
                }
                else if (
                        _userIdStr.equals("admin") && _passwordStr.equals("admin")
                        ){
                    Log.d("USER","GO TO BMI");
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view,new MenuFragment()).commit();
                }else{
                    Toast.makeText(
                            getActivity(),
                            "user or password is incorrect",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("USER","INVALID USERNAME OR PASSWORD");
                }
            }
        });
    }
    void initRegiserBtn(){
        TextView _registerBtn =(TextView) getView().findViewById(R.id.login_register_btn);
        _registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view,new RegisterFragment()).commit();
            }
        });
    }

}
