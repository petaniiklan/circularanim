package id.co.pi.circular.anim;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.co.pi.circular.cA;


public class ListActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        if (getSupportActionBar() != null) {

            getSupportActionBar().setHomeButtonEnabled(true);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void initList() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                final View view = getLayoutInflater().inflate(R.layout.item_list, parent, false);
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 3;
            }

            class MyViewHolder extends RecyclerView.ViewHolder {

                public MyViewHolder(View itemView) {
                    super(itemView);
                    Button button = (Button) itemView.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            cA.fullActivity(ListActivity.this, view)
//                        .colorOrImageRes(R.color.colorPrimary)
                                    .go(new cA.OnAnimationEndListener() {
                                        @Override
                                        public void onAnimationEnd() {
                                            startActivity(new Intent(ListActivity.this, MainActivity.class));
                                            finish();
                                        }
                                    });
                        }
                    });
                }
            }

        });

    }

}
