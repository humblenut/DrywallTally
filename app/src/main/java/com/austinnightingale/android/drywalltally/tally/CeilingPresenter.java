package com.austinnightingale.android.drywalltally.tally;

import com.austinnightingale.android.drywalltally.db.Job;
import com.austinnightingale.android.drywalltally.db.TallyArea;
import com.squareup.sqlbrite.BriteDatabase;

import javax.inject.Inject;

import static com.austinnightingale.android.drywalltally.R.menu.job;

public class CeilingPresenter extends BasePresenter implements Ceiling.Presenter {

    private Ceiling.View ceilingView;

    @Inject
    public CeilingPresenter(BriteDatabase db) {
        super(db);
    }

    @Override
    public void setView(Object view) {
        ceilingView = (Ceiling.View) view;
    }

    @Override
    public int getID() {
        return ceilingView.getID();
    }

    @Override
    public void refreshView(TallyArea tallyArea) {
        ceilingView.updateCeil8Text(strOf(tallyArea.ceilingEight()));
        ceilingView.updateCeil9Text(strOf(tallyArea.ceilingNine()));
        ceilingView.updateCeil10Text(strOf(tallyArea.ceilingTen()));
        ceilingView.updateCeil12Text(strOf(tallyArea.ceilingTwelve()));
        ceilingView.updateCeil14Text(strOf(tallyArea.ceilingFourteen()));
        ceilingView.updateCeil16Text(strOf(tallyArea.ceilingSixteen()));
    }

}
