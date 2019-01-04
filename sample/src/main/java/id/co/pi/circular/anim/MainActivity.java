package id.co.pi.circular.anim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import id.co.pi.circular.cA;


public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar, mProgressBar2;
    Button mChangeBtn, mChangeBtn2, mActivityImageBtn, mActivityColorBtn;
    ImageView mLogoBtnIv;
    LinearLayout mContentLayout;
    boolean isContentVisible = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mChangeBtn = (Button) findViewById(R.id.change_btn);
        mProgressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        mChangeBtn2 = (Button) findViewById(R.id.change_btn2);
        mActivityImageBtn = (Button) findViewById(R.id.activity_image_btn);
        mActivityColorBtn = (Button) findViewById(R.id.activity_color_btn);
        mLogoBtnIv = (ImageView) findViewById(R.id.logoBtn_iv);
        mContentLayout = (LinearLayout) findViewById(R.id.content_layout);

        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressBar.setVisibility(View.VISIBLE);

                cA.hide(mChangeBtn).go();
            }
        });

        mProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressBar.setVisibility(View.GONE);

                cA.show(mChangeBtn).go();
            }
        });

        mChangeBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cA.hide(mChangeBtn2)
                        .endRadius(mProgressBar2.getHeight() / 2)
                        .go(new cA.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                mProgressBar2.setVisibility(View.VISIBLE);
                                mProgressBar2.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        cA.fullActivity(MainActivity.this, mProgressBar2)
                                                .go(new cA.OnAnimationEndListener() {
                                                    @Override
                                                    public void onAnimationEnd() {
                                                        startActivity(new Intent(MainActivity.this, ListActivity.class));
                                                        finish();
                                                    }
                                                });
                                    }
                                }, 3000);
                            }
                        });
            }
        });

        mActivityImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cA.fullActivity(MainActivity.this, view)
                        .colorOrImageRes(R.drawable.greenit)
                        .go(new cA.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                startActivity(new Intent(MainActivity.this, ListActivity.class));
                            }
                        });
            }
        });

        mActivityColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cA.fullActivity(MainActivity.this, view)
//
                        .go(new cA.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                startActivity(new Intent(MainActivity.this, ListActivity.class));
                            }
                        });
            }
        });


        mLogoBtnIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.animate().rotationBy(90);
                if (isContentVisible)
                    cA.hide(mContentLayout).triggerView(mLogoBtnIv).go();
                else
                    cA.show(mContentLayout).triggerView(mLogoBtnIv).go();

                isContentVisible = !isContentVisible;
            }
        });
    }
}
