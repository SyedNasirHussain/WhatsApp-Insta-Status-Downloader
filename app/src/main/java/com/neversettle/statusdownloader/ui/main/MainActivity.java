package com.neversettle.statusdownloader.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.navigation.NavigationView;
import com.neversettle.statusdownloader.R;
import com.neversettle.statusdownloader.injection.app.ApplicationComponent;
import com.neversettle.statusdownloader.injection.main.DaggerMainComponent;
import com.neversettle.statusdownloader.injection.main.MainComponent;
import com.neversettle.statusdownloader.injection.main.MainModule;
import com.neversettle.statusdownloader.ui.utils.BaseActivity;
import com.neversettle.statusdownloader.widget.ContainersLayout;
import com.neversettle.statusdownloader.widget.CustomAppBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    MainContract.Presenter presenter;
    @Inject
    MainContract.Navigator navigator;

    @BindView(R.id.activity_main__nav)
    NavigationView navigationView;

    @BindView(R.id.activity_main__drawer)
    DrawerLayout drawer;
    @BindView(R.id.activity_main__custom_appbar)
    CustomAppBar customAppBar;
    @BindView(R.id.activity_main__containers_layout)
    ContainersLayout containersLayout;
    public static final int RequestPermissionCode = 20;
    private MainComponent mainComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigationView.setNavigationItemSelectedListener(this);
        customAppBar.setOnNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDrawer();
            }
        });


        presenter.attachView(this);


        if (checkPermission()) {

        } else {
            requestPermission();
        }
        if (savedInstanceState == null) {
            presenter.clickWhatsApp();
        }

    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]
                {
                        Manifest.permission.READ_EXTERNAL_STORAGE
                }, RequestPermissionCode);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length > 0) {
                    boolean ReadPhoneStatePermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (ReadPhoneStatePermission) {
//                        presenter.clickProduct();
                    } else {
                        new MaterialDialog.Builder(MainActivity.this)
                                .title("Permission Required")
                                .content("This app doesn't work without the required permissions")
                                .positiveText("OK")
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        finish();
                                        System.exit(0);
                                    }
                                })
                                .show();
                    }
                }
                break;
        }
    }

    public boolean checkPermission() {
        int firstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.READ_PHONE_STATE);

        return firstPermissionResult == PackageManager.PERMISSION_GRANTED;
    }


    @Override
    protected void setupActivityComponent(ApplicationComponent applicationComponent) {
        mainComponent = DaggerMainComponent.builder()
                .applicationComponent(applicationComponent)
                .mainModule(new MainModule(this))
                .build();

        mainComponent.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_main_nav__whatsapp:
                presenter.clickWhatsApp();
                break;

            case R.id.menu_main_nav__instagram:
                presenter.clickInstagram();
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public void closeDrawer() {
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.postDelayed(new Runnable() {
                @Override
                public void run() {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }, 100);
        }
    }

    @Override
    public void openDrawer() {
        if (drawer != null && !drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    public void toggleDrawer() {
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (drawer != null && !drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
        }
    }


    @Override
    public void highlightWhatsApp() {
        navigationView.setCheckedItem(R.id.menu_main_nav__whatsapp);
    }

    @Override
    public void highlightInstagram() {
        navigationView.setCheckedItem(R.id.menu_main_nav__instagram);
    }

    public CustomAppBar getCustomAppBar() {
        return customAppBar;
    }

    public ContainersLayout getContainersLayout() {
        return containersLayout;
    }

    public MainContract.Navigator getNavigator() {
        return navigator;
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }


    @Override
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (!navigator.onBackPressed()) {
            super.onBackPressed();
        }
    }
}