package com.example.lab203_19.healty;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by LAB203_19 on 20/8/2561.
 */

public class RegisterFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container , false) ;
    }
    public void onActivityCreated(
            @Nullable Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);

        initRegisterBtn();

    }
    void initRegisterBtn(){
        Button _registerBtn = (Button) getView().findViewById(R.id.register_register_btn);
        _registerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText _userId = (EditText) getView().findViewById(R.id.register_user_id);
                EditText _name = (EditText) getView().findViewById(R.id.register_name);
                EditText _age = (EditText) getView().findViewById(R.id.register_age);
                EditText _password = (EditText) getView().findViewById(R.id.register_password);

                String _userIdStr = _userId.getText().toString();
                String _nameStr = _name.getText().toString();
                String _ageStr = _age.getText().toString();
                String _passwordStr = _password.getText().toString();
                if(_userIdStr.isEmpty() || _passwordStr.isEmpty() || _ageStr.isEmpty() || _passwordStr.isEmpty()){
                    Toast.makeText(
                            getActivity(),
                            "please fill that all information",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER","FIFLD NAME IS EMPTY");
                }
                else if (
                        _userIdStr.equals("admin")
                        ){
                    Toast.makeText(
                            getActivity(),
                            "user ID has been already",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER","USER ALREADY EXIST");
                }else{
                    Log.d("REGISTER","GO TO BMI");
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view,new BMIFragment()).commit();
                }
            }
        });
    }
}
