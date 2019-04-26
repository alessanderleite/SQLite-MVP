package br.com.alessanderleite.sqlitemvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.alessanderleite.sqlitemvp.R;
import br.com.alessanderleite.sqlitemvp.presenter.IPresenter;
import br.com.alessanderleite.sqlitemvp.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    private IPresenter iPresenter;
    private ListView mListView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        iPresenter = new Presenter(this);
        iPresenter.setDataToListView();
    }

    private void initView() {
        mListView1 = (ListView) findViewById(R.id.listview1);
    }
    @Override
    public void setDataToListView(List<String> categoriesToList) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoriesToList);
        mListView1.setAdapter(arrayAdapter);
    }
}
