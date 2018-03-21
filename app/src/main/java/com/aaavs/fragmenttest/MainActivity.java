package com.aaavs.fragmenttest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);


//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
////        Fragment1 fragment1 = new Fragment1();
////        fragmentTransaction.add(R.id.frag1,fragment1);
//
//        Fragment2 fragment2 = new Fragment2();
//        fragmentTransaction.add(R.id.frag2,fragment2);
//        fragmentTransaction.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                commitF();
                Log.i(TAG, "onClick: ");
                break;
        }

    }

    private void commitF() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment2 f = (Fragment2) fm.findFragmentByTag("tag");

        if(f == null) {  // not added
            f = new Fragment2();
            ft.add(R.id.forFrag, f, "tag");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        } else {  // already added

            ft.remove(f);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        }

        ft.commit();
    }
}
