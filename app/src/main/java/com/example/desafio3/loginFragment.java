package com.example.desafio3;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.desafio3.databinding.FragmentLoginBinding;


public class loginFragment extends Fragment {

    private FragmentLoginBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        registerListener();

        return binding.getRoot();
    }

    private void registerListener () {
        binding.passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence cs, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (passValida(charSequence.toString())) {
                    binding.button1.setEnabled(true);
                    irSecondFragment();

                } else {
                    binding.button1.setEnabled(false);
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        binding.button1.setOnClickListener(view -> showMessage());
    }

    private boolean passValida (String pass){
        return pass.length() > 5 && pass.matches("[A-Z]");
    }
    private void showMessage() {
        binding.textView.setVisibility(View.VISIBLE);
    }

   private void irSecondFragment () {
        Fragment secondFragment = new secondFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, secondFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


   }


}