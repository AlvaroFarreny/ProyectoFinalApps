package com.example.pictopocketiv;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.pictopocketiv.search.PictoAddCategroyFragment;

public class PictoAddCategory extends AppCompatActivity {


    /** ACTIVITY STATE ENUM **/
    private enum ActivityState {
        WAITING_FOR_INPUT,
        SEARCHING,
        SHOWING_RESULT;
    }


    /** ATTRS **/
    private ActivityState mState = ActivityState.WAITING_FOR_INPUT;

    private FragmentManager mFramesManager;


    /** LIFECYCLE **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picto_addcategory);
        initUI();
    }


    /** UI **/
    private void initUI() {
        setWidgets();
        setFrames();
    }

    private void setWidgets() {
        FrameLayout mFrameLayout = (FrameLayout) findViewById(R.id.addcategory_fragment_container);
        mFramesManager = getSupportFragmentManager();

        //mActionBar = getSupportActionBar();
        //mActionBar.hide();
    }

    private void setFrames() {
        PictoAddCategroyFragment mAddCategoryFragment = PictoAddCategroyFragment.newInstance(this);
        FragmentTransaction ft = mFramesManager.beginTransaction();
        ft.replace(R.id.addcategory_fragment_container, mAddCategoryFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}