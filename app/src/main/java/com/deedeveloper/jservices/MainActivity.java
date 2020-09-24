package com.deedeveloper.jservices;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.firebase.messaging.FirebaseMessaging;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment = null;
    String TAG;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase Massaging By Topic
        FirebaseMessaging.getInstance().subscribeToTopic("weather")
                .addOnCompleteListener(task -> {
                    String msg = getString(R.string.msg_subscribed);
                    if (!task.isSuccessful()) {
                        msg = getString(R.string.msg_subscribe_failed);
                    }
                    Log.d(TAG, msg);
//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                });
        myDialog = new Dialog(this);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        ChipNavigationBar chipNavigationBar = findViewById(R.id.chipNavigation);
        chipNavigationBar.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();

        chipNavigationBar.setOnItemSelectedListener(i -> {
            switch (i) {
                case R.id.home:
                    fragment = new HomeFragment();
                    break;
                case R.id.market:
                    fragment = new CartFragment();
                    break;
                case R.id.profile:
                    fragment = new ProfileFragment();
                    break;
            }
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
            }
        });
    }

    public void ShowPopUp(View view) {
        TextView closeText;
        ImageView emailImage;
        ImageView instagramImage;
        ImageView imageShare;
        myDialog.setContentView(R.layout.toolbar_about_info);
        closeText = myDialog.findViewById(R.id.close_text);
        closeText.setOnClickListener(view1 -> myDialog.dismiss());
        emailImage = myDialog.findViewById(R.id.emailImage);
        emailImage.setOnClickListener(view12 -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setType("message/rfc822")
                    .setData(Uri.parse("mailto: mrdkjangid@gmail.com"))
                    .setPackage("com.google.android.gm");
            startActivity(intent);
        });
        instagramImage = myDialog.findViewById(R.id.instagramImage);
        instagramImage.setOnClickListener(view13 -> {
            Uri uri = Uri.parse("http://instagram.com/mr.deep.z");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
            likeIng.setPackage("com.instagram.android");
            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/mr.deep.z")));
            }
        });
        imageShare = myDialog.findViewById(R.id.imageShare);
        imageShare.setOnClickListener(view14 -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Read android Share Function at https://deedeveloper.com");
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "JHUNJHUNU APP");
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });
        //myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}