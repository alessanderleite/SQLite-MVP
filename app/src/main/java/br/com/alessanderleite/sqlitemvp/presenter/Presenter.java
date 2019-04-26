package br.com.alessanderleite.sqlitemvp.presenter;

import java.util.List;

import br.com.alessanderleite.sqlitemvp.model.IModel;
import br.com.alessanderleite.sqlitemvp.model.Model;
import br.com.alessanderleite.sqlitemvp.view.IMainActivity;

public class Presenter implements IPresenter {

    private IMainActivity iMainActivity;
    private IModel iModel;

    public Presenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iModel = new Model(iMainActivity);
    }

    @Override
    public void setDataToListView() {
        List<String> list = iModel.getListFromDatabase();
        iMainActivity.setDataToListView(list);
    }
}
